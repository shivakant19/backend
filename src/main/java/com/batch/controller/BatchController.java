package com.batch.controller;


import com.batch.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/batch/jobs")
public class BatchController {

    @Autowired
    private BatchService batchService;


    @PostMapping("launch")
    public String launchJob(){
        return batchService.launchJob();
    }
}
