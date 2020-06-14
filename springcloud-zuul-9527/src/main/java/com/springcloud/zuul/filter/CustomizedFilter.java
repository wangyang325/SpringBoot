package com.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomizedFilter extends ZuulFilter {
    /**
     * filterType: pre
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filter run order，0 is high priority
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * if run filter
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        // request parameter
        String token = request.getParameter("token");

        // TODO
        token = "tokenKey";

        // check token
        if (StringUtils.isNotBlank(token) && token.equals("tokenKey")) {
            requestContext.setSendZuulResponse(true);
            requestContext.setResponseStatusCode(200);
            requestContext.set("code", 1);
        } else {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            HttpServletResponse response = requestContext.getResponse();
            response.setHeader("content-type", "text/html;charset=utf-8");
            requestContext.setResponseBody("authority failed");
            requestContext.set("code", 0);
        }
        return null;
    }
}

