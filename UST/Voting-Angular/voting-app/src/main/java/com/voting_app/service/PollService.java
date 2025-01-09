package com.voting_app.service;

import com.voting_app.model.Poll;
import com.voting_app.repository.PollRepo;
import org.springframework.stereotype.Service;

@Service
public class PollService {

    private final PollRepo pollRepo;

    public PollService(PollRepo pollRepo) {
        this.pollRepo = pollRepo;
}

    public Poll createPoll(Poll poll) {
        return pollRepo.save(poll);
    }
}
