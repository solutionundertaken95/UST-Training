package com.telusko.Service;


import com.telusko.Repository.JobRepo;
import com.telusko.Model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    public JobRepo repo;



    //method to return all JobPosts
    public List<JobPost> returnAllJobPosts() {
        return repo.returnAllJobPosts();


    }

    public void addPost(JobPost jobPost){
        repo.addJobPost(jobPost);
    }

    public JobPost viewJobById(int id){
        return  repo.viewJobById(id);
    }





    // ***************************************************************************





    // method to add a jobPost
    public void addJobPost(JobPost jobPost) {
        repo.addJobPost(jobPost);

    }


    public JobPost updateJob(JobPost jobPost, int id) {
        return repo.updateJob(jobPost,id);
    }

    public void deleteJob(int id){
        repo.deleteJob(id);
    }
}