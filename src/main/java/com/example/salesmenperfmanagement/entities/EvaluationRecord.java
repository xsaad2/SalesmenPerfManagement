package com.example.salesmenperfmanagement.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class EvaluationRecord {

    @Id
    private Integer goal_id;

    private String description;

    private Integer target_value;

    private Integer actual_value;

    private Integer year;
}
