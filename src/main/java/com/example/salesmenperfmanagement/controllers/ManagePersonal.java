package com.example.salesmenperfmanagement.controllers;

import com.example.salesmenperfmanagement.entities.EvaluationRecord;
import com.example.salesmenperfmanagement.entities.SalesMan;


import java.util.List;
import java.util.Optional;

public interface ManagePersonal {

    public void createSalesMan( SalesMan record );

    public void addPerformanceRecord(EvaluationRecord record , int sid );

    public Optional<SalesMan> readSalesMan(int sid );

    public List<SalesMan> querySalesMan(String attribute , String key );

    public List<EvaluationRecord> readEvaluationRecords( int sid );

    public void deleteSalesMan(int sid);

    public void deleteRecord(Integer sid, Integer goal_id);

}