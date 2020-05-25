package wangyang.service;

import java.util.concurrent.Future;

public interface AsyncService {
    Future<String> doTask1() throws Exception;
}
