package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("This is an info message");
        logger.debug("This is a debug message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
    }

}
