package com.example.board.repository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository{

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init(){}
}