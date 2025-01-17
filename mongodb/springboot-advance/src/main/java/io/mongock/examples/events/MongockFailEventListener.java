package io.mongock.examples.events;

import io.mongock.runner.spring.base.events.SpringMigrationFailureEvent;
import org.springframework.context.ApplicationListener;

public class MongockFailEventListener implements ApplicationListener<SpringMigrationFailureEvent> {

    @Override
    public void onApplicationEvent(SpringMigrationFailureEvent event) {
        System.out.println("[EVENT LISTENER] - Mongock finished with failures: "
                + event.getMigrationResult().getException().getMessage());
    }

}
