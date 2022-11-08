package com.example.salesmenperfmanagement.controllers;

import com.example.salesmenperfmanagement.entities.EvaluationRecord;
import com.example.salesmenperfmanagement.entities.SalesMan;
import com.example.salesmenperfmanagement.services.ManagePersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ManagePersonalController {
    @Autowired
    private ManagePersonalService managePersonalService;

    @PostMapping("addsalesman")
    public void createSalesMan(@RequestBody SalesMan salesman) {
        managePersonalService.createSalesMan(salesman);
    }

    @PostMapping("addperfrecord/{sid}")
    public void addPerformanceRecord(@RequestBody EvaluationRecord record, @PathVariable int sid) {
        managePersonalService.addPerformanceRecord(record,sid);
    }
    @GetMapping("allrecords")
    public List<SalesMan> readAll(){
        return managePersonalService.readAllSalesmen();
    }

    @GetMapping("salesmen/{sid}")
    public SalesMan readSalesMan(@PathVariable int sid) {
        return managePersonalService.readSalesMan(sid).get();
    }

    @GetMapping("getrecords/{sid}")
    public List<EvaluationRecord> readEvaluationRecords(@PathVariable int sid) {
        return managePersonalService.readEvaluationRecords(sid);
    }

    @DeleteMapping("delete/{sid}")
    public void deleteSalesMan(@PathVariable int sid) {
        managePersonalService.deleteSalesMan(sid);
    }

    @DeleteMapping("delete/{sid}/{goal_id}")
    public void deleteRecord(Integer sid, Integer goal_id) {
        managePersonalService.deleteRecord(sid, goal_id);
    }
}
