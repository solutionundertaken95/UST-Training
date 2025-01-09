package com.telusko.Controller;

import com.telusko.Model.JobPost;
import com.telusko.Repository.JobRepo;
import com.telusko.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    public List<JobPost> viewAllJobs(){
        return jobService.returnAllJobPosts();
    }

    @PostMapping("jobPosts")
    public void addJob(@RequestBody JobPost jobPost){
        jobService.addJobPost(jobPost);
    }

    @GetMapping("job/{id}")
    public JobPost viewJobById(@PathVariable int id){
        return jobService.viewJobById(id);
    }

    @PutMapping("job/{id}")
    public JobPost updateJob(@RequestBody JobPost jobPost, @PathVariable int id){
        return jobService.updateJob(jobPost,id);
    }

    @DeleteMapping("jobPost/{id}")
    public String deleteJob(@PathVariable int id){
        jobService.deleteJob(id);
        return "Deleted Successfully";
    }

}
