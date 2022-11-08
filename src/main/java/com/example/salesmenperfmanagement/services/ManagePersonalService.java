package com.example.salesmenperfmanagement.services;


import com.example.salesmenperfmanagement.entities.EvaluationRecord;
import com.example.salesmenperfmanagement.entities.SalesMan;

import java.util.List;
import java.util.Optional;

public interface ManagePersonalService {

     void createSalesMan( SalesMan record );

     void addPerformanceRecord(EvaluationRecord record , int sid );

     Optional<SalesMan> readSalesMan(int sid );


     List<EvaluationRecord> readEvaluationRecords( int sid );

     void deleteSalesMan(int sid);

     void deleteRecord(Integer sid, Integer goal_id);

    List<SalesMan> readAllSalesmen();
}
