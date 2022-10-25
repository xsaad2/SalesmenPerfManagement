package com.example.salesmenperfmanagement.repositories;

import com.example.salesmenperfmanagement.entities.SalesMan;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * Mongo Repository interface for getting the Salesmen in the database
 */
public interface SalesManRepo extends MongoRepository<SalesMan,Integer> {

}
