package com.yet.spring.loggers;

import com.yet.spring.beans.Event;

import java.util.Collection;

public class CombinedEventLoggers implements EventLogger {
    private final Collection<EventLogger> loggers;

    public CombinedEventLoggers(Collection<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLogger : loggers) {
            eventLogger.logEvent(event);
        }
    }
}
