package com.voting_app.repository;

import com.voting_app.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepo extends JpaRepository<Poll,Long> {
}



