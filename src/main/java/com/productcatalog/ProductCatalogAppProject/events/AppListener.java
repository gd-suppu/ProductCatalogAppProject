package com.productcatalog.ProductCatalogAppProject.events;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
public class AppListener {
    @EventListener(ApplicationStartedEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("Product catalog application started");
    }
}
