package com.example.springbootrest;

import com.example.springbootrest.model.JobPost;
import com.example.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobs")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("job/{jobId}")
    public JobPost getJob(@PathVariable("jobId") int jobId) {
        return service.getJob(jobId);
    }

    @PostMapping("job")
    public JobPost addJob(@RequestBody JobPost job) {
        service.addJob(job);
        return service.getJob(job.getPostId());
    }

    @PutMapping ("job")
    public JobPost updateJob(@RequestBody JobPost job) {
        service.updateJob(job);
        return service.getJob(job.getPostId());
    }

    @DeleteMapping("job/{jobId}")
    public String deleteJob(@PathVariable int jobId) {
        service.deleteJob(jobId);
        return "Deleted";
    }

    @GetMapping("load")
    public String addAllJobs() {
        service.loadData();
        return "Success";
    }

    @GetMapping("jobs/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        return service.searchByKeyword(keyword);
    }

}
