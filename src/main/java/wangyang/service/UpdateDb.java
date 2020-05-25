package wangyang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wangyang.db.DbService;

@Service
public class UpdateDb {

    @Autowired
    private DbService dbSer;

    public void update() {
        dbSer.insert();
    }

}
