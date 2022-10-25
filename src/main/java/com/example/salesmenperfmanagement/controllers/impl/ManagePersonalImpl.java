package com.example.salesmenperfmanagement.controllers.impl;

import com.example.salesmenperfmanagement.controllers.ManagePersonal;
import com.example.salesmenperfmanagement.entities.EvaluationRecord;
import com.example.salesmenperfmanagement.entities.SalesMan;
import com.example.salesmenperfmanagement.repositories.EvaluationRecordRepo;
import com.example.salesmenperfmanagement.repositories.SalesManRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ManagePersonalImpl implements ManagePersonal {

    @Autowired
    private SalesManRepo salesManRepo;

    private final MongoTemplate mongoTemplate;

    public ManagePersonalImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    @PostMapping("addsalesman")
    public void createSalesMan(@RequestBody SalesMan salesman) {
        salesManRepo.save(salesman);
    }

    @Override
    @PostMapping("addperfrecord/{sid}")
    public void addPerformanceRecord(@RequestBody EvaluationRecord record, @PathVariable int sid) {
        SalesMan salesman =salesManRepo.findById(sid)
                .get();
        if(!salesman.getEvaluationRecords().contains(record)) {
            salesman.getEvaluationRecords().add(record);
            salesManRepo.save(salesman);
        }
        else System.out.println("Record already exists");
    }

    @Override
    @GetMapping("salesmen/{sid}")
    public Optional<SalesMan> readSalesMan(@PathVariable int sid) {
        return salesManRepo.findById(sid);
    }

    @Override
    @GetMapping("query/{attribute}/{key}")
    public List<SalesMan> querySalesMan(@PathVariable String attribute,@PathVariable String key) {
        Query query = new Query()
                .addCriteria(Criteria.where(""+attribute).is(key));
        return mongoTemplate.find(query,SalesMan.class);
    }
    @Override
    @GetMapping("getrecords/{sid}")
    public List<EvaluationRecord> readEvaluationRecords(@PathVariable int sid) {
        return salesManRepo.findById(sid)
                .get()
                .getEvaluationRecords();
    }

    @Override
    @DeleteMapping("delete/{sid}")
    public void deleteSalesMan(@PathVariable int sid) {
        salesManRepo.deleteById(sid);
    }

    @Override
    @DeleteMapping("delete/{sid}/{goal_id}")
    public void deleteRecord(Integer sid, Integer goal_id) {
        salesManRepo.findById(sid)
                .get()
                .getEvaluationRecords()
                .removeIf(x -> x.getGoal_id()==goal_id );
    }

}
