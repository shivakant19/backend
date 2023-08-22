package com.batch.config;

import com.batch.model.User;
import com.batch.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserWriter implements ItemWriter<User> {


    @Autowired
    private UserRepository userRepository;

    @Override
    public void write(List<? extends User> list) throws Exception {
        System.out.println("Thread Name : -"+Thread.currentThread().getName());
        userRepository.saveAll(list);
    }
}
