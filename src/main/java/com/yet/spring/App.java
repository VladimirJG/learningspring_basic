package com.yet.spring;

import com.yet.spring.beans.Client;
import com.yet.spring.beans.ConsoleEventLogger;
import com.yet.spring.beans.Event;
import com.yet.spring.beans.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) context.getBean("app");

        Event event = context.getBean(Event.class);
        app.logEvent(event, "Some event for user 1");

        event = context.getBean(Event.class);
        app.logEvent(event, "Some event for user 2");
    }

    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }
}
