package com.example.salesmenperfmanagement.services;

import com.example.salesmenperfmanagement.entities.EvaluationRecord;
import com.example.salesmenperfmanagement.entities.SalesMan;
import com.example.salesmenperfmanagement.repositories.SalesManRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ManagePersonalServiceImpl implements ManagePersonalService {

    @Autowired
    private SalesManRepo salesManRepo;


    @Override
    public void createSalesMan(SalesMan salesman) {
        salesManRepo.save(salesman);
    }

    @Override
    public void addPerformanceRecord(EvaluationRecord record, int sid) {
        SalesMan salesman =salesManRepo.findById(sid)
                .get();
        if(!salesman.getEvaluationRecords().contains(record)) {
            salesman.getEvaluationRecords().add(record);
            salesManRepo.save(salesman);
        }
        else System.out.println("Record already exists");
    }

    @Override
    public Optional<SalesMan> readSalesMan(int sid) {
        return salesManRepo.findById(sid);
    }

    @Override
    public List<EvaluationRecord> readEvaluationRecords(int sid) {
        return salesManRepo.findById(sid)
                .get()
                .getEvaluationRecords();
    }

    @Override
    public void deleteSalesMan(int sid) {
        salesManRepo.deleteById(sid);
    }

    @Override
    public void deleteRecord(Integer sid, Integer goal_id) {
        salesManRepo.findById(sid)
                .get()
                .getEvaluationRecords()
                .removeIf(x -> x.getGoal_id()==goal_id );
    }

    @Override
    public List<SalesMan> readAllSalesmen() {
        return salesManRepo.findAll();
    }
}
