package com.sbx.firstjobapp.job.service;

import com.sbx.firstjobapp.job.Job;

import java.util.List;

public interface JobService {
    // created interface for loose coupling
    List<Job> findAll();
    void createJob(Job job);
}
