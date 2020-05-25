package wangyang.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class DbService {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    public void insert()
    {
        //jdbcTemplate.update("insert into ");
        System.out.println("Insert Db");
    }

}
