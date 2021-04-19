package com.github.cloudyrock.mongock.examples.client;

import com.github.cloudyrock.mongock.examples.Spring5SpringData3Builder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(Spring5SpringData3Builder.CLIENTS_COLLECTION_NAME)
public interface ClientRepository extends MongoRepository<Client, String> {

}