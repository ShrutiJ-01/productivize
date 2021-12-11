package com.example.productivize;
import com.example.gui.RegisterationSystem;

import java.util.logging.Logger;

//Starting point of our application

public final class App {

    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log =Logger.getLogger(App.class.getName());
    }

    public static void main(String[] args) throws Exception {
        log.info("---STARTING APPLICATION PRODUCTIVIZE---");
        RegisterationSystem.main(args);
        //LoginSystem.build();
    }

}
