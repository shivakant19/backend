package com.batch.config;

import com.batch.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class UserItemProcessor implements ItemProcessor<User,User> {


    @Override
    public User process(User item) throws Exception {
        log.info("---------Hello----------------");
        return item;
    }
}
