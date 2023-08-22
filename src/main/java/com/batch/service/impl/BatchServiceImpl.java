package com.batch.service.impl;

import com.batch.service.BatchService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchServiceImpl implements BatchService {


    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Override
    public String launchJob() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt",System.currentTimeMillis())
                .toJobParameters();

        try {
            jobLauncher.run(job,jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobParametersInvalidException | JobRestartException |
                 JobInstanceAlreadyCompleteException e) {
            throw new RuntimeException(e);
        }
        return "Job executed Successfully";
    }
}
