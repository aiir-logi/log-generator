package com.example.loggenerator;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Component
public class LoggingComponent {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private Lorem lorem = LoremIpsum.getInstance();

    @Scheduled(fixedDelay = 1000L)
    void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0; i<10; i++) {
            executorService.submit(this::log);
        }
    }

    @SneakyThrows
    void log() {
        while(true) {
            logger.warn(lorem.getWords(5, 10));
            logger.info(lorem.getWords(2, 5));
            logger.error(lorem.getWords(7, 10));
            logger.trace(lorem.getWords(10, 15));
            Thread.sleep(500);
        }
    }
}
