package com.sbx.firstjobapp.service;

import com.sbx.firstjobapp.job.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    private List<Job> jobs = new ArrayList<>();
    private long nextId =1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++); // increament the value
        jobs.add(job);
    }

    @Override
    public Job getById(long id) {
        for (Job job:jobs
             ) {
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJob(Long id) {
        Iterator<Job> iterator=jobs.iterator();
        while(iterator.hasNext()){
            Job job = iterator.next();
            if (job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
