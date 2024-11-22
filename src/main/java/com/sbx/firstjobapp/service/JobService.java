package com.sbx.firstjobapp.service;

import com.sbx.firstjobapp.job.Job;

import java.util.List;

public interface JobService {
    // created interface for loose coupling
    List<Job> findAll();
    void createJob(Job job);

    Job getById(long id);

    boolean deleteJob(Long id);
}
