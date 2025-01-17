package io.mongock.examples.changelogs.client.updater;

import io.mongock.examples.client.Client;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;

import org.springframework.data.mongodb.core.MongoTemplate;

import static io.mongock.examples.application.SpringBootAdvanceApp.CLIENTS_COLLECTION_NAME;

@ChangeUnit(id="client-updater-runalways", order = "3", author = "mongock", runAlways = true)
public class ClientUpdaterRunAlwaysChangeLog  {

  @Execution
  public void execution(MongoTemplate mongoTemplate) {

    mongoTemplate.findAll(Client.class, CLIENTS_COLLECTION_NAME)
            .stream()
            .map(client -> client.setCounter(client.getCounter() + 1))
            .forEach(client -> mongoTemplate.save(client, CLIENTS_COLLECTION_NAME));
  }

  @RollbackExecution
  public void rollbackExecution(MongoTemplate mongoTemplate) {

    mongoTemplate.findAll(Client.class, CLIENTS_COLLECTION_NAME)
            .stream()
            .map(client -> client.setCounter(client.getCounter() - 1))
            .forEach(client -> mongoTemplate.save(client, CLIENTS_COLLECTION_NAME));
  }
}
