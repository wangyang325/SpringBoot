package wangyang.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyJob {
    @Scheduled(fixedRate = 10)
    public void run() {
        System.out.println("This is job");
    }
}
