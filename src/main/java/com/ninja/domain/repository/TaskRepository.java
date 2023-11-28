package com.ninja.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ninja.domain.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
