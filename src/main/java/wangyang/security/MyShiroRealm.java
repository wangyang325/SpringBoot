package wangyang.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    // Db service
//    @Autowired
//    private SysRoleService roleService;
//    @Autowired
//    private UserService userService;

    /**
     * Authentication for user
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        logger.info("---------------- 执行 Shiro 凭证认证 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String name = token.getUsername();
        String password = String.valueOf(token.getPassword());
        SysUser user = new SysUser();
        user.setUserName(name);
        user.setPassWord(password);
        // TODO Search user from db
        SysUser userList = new SysUser();
        if (userList != null) {
            // disable
            if (userList.getUserEnable() != 1) {
                throw new DisabledAccountException();
            }
            logger.info("---------------- Shiro success ----------------------");
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    userList, // user
                    userList.getPassWord(), // password
                    getName()  //realm name
            );
            return authenticationInfo;
        }
        throw new UnknownAccountException();
    }

    /**
     * Authorization
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("---------------- run Shiro get Authorization ---------------------");
        Object principal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (principal instanceof SysUser) {
            SysUser userLogin = (SysUser) principal;
            // TODO findRoleNameByUserId from db
            // roleService.findRoleNameByUserId(userLogin.getId());
            Set<String> roles = new HashSet<String>();
            authorizationInfo.addRoles(roles);

            // TODO findPermissionsByUserId from db
            // Set<String> permissions = userService.findPermissionsByUserId(userLogin.getId());
            Set<String> permissions = new HashSet<String>();
            authorizationInfo.addStringPermissions(permissions);
        }

        logger.info("---- get authorization ----");
        logger.info(authorizationInfo.getStringPermissions().toString());
        logger.info("---------------- Shiro success ----------------------");
        return authorizationInfo;
    }

    /**
     * clear user cache
     */
    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCachedAuthorizationInfo(principals);
    }

    /**
     * clear user cache
     */
    public void clearAllCachedAuthorizationInfo() {
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
        if (cache != null) {
            for (Object key : cache.keys()) {
                cache.remove(key);
            }
        }
    }
}

