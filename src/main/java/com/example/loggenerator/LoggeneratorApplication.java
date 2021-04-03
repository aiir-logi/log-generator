package com.example.loggenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggeneratorApplication {
    private static Logger logger = LogManager.getLogger(LoggeneratorApplication.class);
    public static void main(String[] args)
    {
        logger.error("Logger works");
        SpringApplication.run(LoggeneratorApplication.class, args);
    }

}
