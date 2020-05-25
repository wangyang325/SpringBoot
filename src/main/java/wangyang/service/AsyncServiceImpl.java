package wangyang.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
@Service
public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async
    public Future<String> doTask1() throws Exception {
        System.out.println("Task1 is running");
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        System.out.println("Task1 is end. time:" + (end-start));
        return new AsyncResult<>("Task1 is end.");
    }
}
