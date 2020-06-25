package com.tasklets.restbest.repository;

import com.tasklets.restbest.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
