package com.sbx.firstjobapp.job;

import com.sbx.firstjobapp.job.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // GET  /jobs/all-jobs : get all jobs
    @GetMapping("/all-jobs")
    public List<Job> findAll(){
        return jobService.findAll();
    }

    // GET /jobs/{id} : Get a specific job by ID
    // POST /jobs : Create a new jon(request body should contain the job details)
    @PostMapping
    public String createJob(@RequestBody Job job){
        jobService.createJob(job);
        return "Job added successfully";
    }


    // DELETE /jobs/{id} : Delete a specific job by ID
    // PUT /jobs/{id} : Update a specific job by ID(request body should contain the updated jobs)



    // tools use JSONLint : to create JSON
}
