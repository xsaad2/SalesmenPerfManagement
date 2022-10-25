package com.example.salesmenperfmanagement;

import com.example.salesmenperfmanagement.entities.EvaluationRecord;
import com.example.salesmenperfmanagement.entities.SalesMan;
import com.example.salesmenperfmanagement.repositories.SalesManRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RoundTripTest {

    private SalesMan salesMan = new SalesMan();
    private EvaluationRecord evaluationRecord = new EvaluationRecord();

    @Autowired
    private SalesManRepo salesManRepo;

    @BeforeEach
    void init(){
        //initializing the saleman
        salesMan.setName("Jordan Belfort");
        salesMan.setDepartment("Sales");
        salesMan.setSid(123457);

        //initializing a record

        evaluationRecord.setGoal_id(100001);
        evaluationRecord.setDescription("Sales record");
        evaluationRecord.setTarget_value(1544);
        evaluationRecord.setActual_value(1600);
        evaluationRecord.setYear(2022);

        //adding the record to the salesman's list
        salesMan.setEvaluationRecords(List.of(evaluationRecord));
    }

    // Test for creating and reading from the database
    @Test
    public void createAndReadSalemanTest(){
        salesManRepo.save(salesMan);
        assertEquals(salesManRepo.findById(123457).get().getName(),"Jordan Belfort");
        assertEquals(salesManRepo.findById(123457).get().getDepartment(),"Sales");
        assertTrue(salesManRepo.findById(123457).get().getEvaluationRecords().contains(evaluationRecord));
    }

    //Test for deleting from the database
    @Test
    public void deleteSalesmanTest(){
        salesManRepo.deleteById(123457);
        Optional<SalesMan> salesmanAfterDeletion = salesManRepo.findById(123457);
        assertFalse(salesmanAfterDeletion.isPresent());
    }
}
