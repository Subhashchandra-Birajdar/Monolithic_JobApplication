package com.sbx.firstjobapp.job;

import com.sbx.firstjobapp.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs") // used at method level or class level, used as base URL for all URI
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // GET  /jobs/all-jobs : get all jobs
    //@GetMapping("/all-jobs") -- Specialise version of request mapping
    @RequestMapping(value = "/all-jobs",method=RequestMethod.GET)
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }

    // GET /jobs/{id} : Get a specific job by ID
    @GetMapping("/{id}") // id is dynamic we are passing runtime
    public ResponseEntity<Job> getSingleJob(@PathVariable long id){
        // pathvariable extract the values from the URI and add with method parameter
        Job job = jobService.getById(id);
        if(job!=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    // POST /jobs : Create a new jon(request body should contain the job details)
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
    }


    // DELETE /jobs/{id} : Delete a specific job by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean delete = jobService.deleteJob(id);
        if(delete)
            return  new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // PUT /jobs/{id} : Update a specific job by ID(request body should contain the updated jobs)
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,
                                            @RequestBody Job updateJob){
        Boolean updated = jobService.updateJob(id,updateJob);
        if(updated)
            return new ResponseEntity<>("Job is updated",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // tools use JSONLint : to create JSON
}
