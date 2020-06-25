package com.tasklets.restbest.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.tasklets.restbest.entity.Message;
import com.tasklets.restbest.entity.Views;
import com.tasklets.restbest.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageRepository messageRepository;

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Message> list(){
        return messageRepository.findAll();
    }

    @GetMapping("{id}")
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        message.setCreationDate(LocalDateTime.now());
        return messageRepository.save(message);
    }

    @PutMapping("{id}")
    public Message update(
            @PathVariable("id") Long id,
            @RequestBody Message message){
        Optional<Message> messageFromDb = messageRepository.findById(id);
        BeanUtils.copyProperties(message, messageFromDb.get(), "id");
        return messageRepository.save(messageFromDb.get());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        messageRepository.deleteById(id);
    }
}
