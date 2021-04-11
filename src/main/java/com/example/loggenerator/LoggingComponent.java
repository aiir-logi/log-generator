package com.example.loggenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class LoggingComponent {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Scheduled(fixedDelay = 1000L)
    void run() throws InterruptedException {
        while(true) {
            logger.warn("test");
            Thread.sleep(500);
        }
    }
}
