package com.yet.spring.loggers;

import com.yet.spring.beans.Event;

public class ConsoleEventLogger extends AbstractLogger {
    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
