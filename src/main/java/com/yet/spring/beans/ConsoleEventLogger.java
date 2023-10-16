package com.yet.spring.beans;

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(String msg) {
        System.out.println(msg);
    }
}
