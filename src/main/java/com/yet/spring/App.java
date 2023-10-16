package com.yet.spring;

import com.yet.spring.beans.Client;
import com.yet.spring.beans.ConsoleEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) context.getBean("app");

        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");
    }

    private Client client;
    private ConsoleEventLogger eventLogger;

    public App(Client client, ConsoleEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getName());
        eventLogger.logEvent(message);
    }
}
