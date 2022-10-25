package com.example.salesmenperfmanagement.repositories;

import com.example.salesmenperfmanagement.entities.EvaluationRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EvaluationRecordRepo extends MongoRepository<EvaluationRecord,Integer> {
}
