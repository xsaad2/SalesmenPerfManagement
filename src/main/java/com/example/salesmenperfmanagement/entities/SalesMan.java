package com.example.salesmenperfmanagement.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.util.List;

@Document
@Data
public class SalesMan {

    @Id
    private Integer sid;
    private String name;
    private String department;
    private List<EvaluationRecord> evaluationRecords;

}

