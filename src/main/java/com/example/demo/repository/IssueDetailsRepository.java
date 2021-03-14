package com.example.demo.repository;

import com.example.demo.domain.IssueDetails;
import com.example.demo.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueDetailsRepository extends CrudRepository<IssueDetails, Long> {

    @Override
    List<IssueDetails> findAll();
}
