package com.lance.repository;

import com.lance.entity.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest03 {

    @Autowired
    private UserRepository03 userRepository;

    @Test
    public void testFindByUsername() {
        UserDO user = userRepository.findByUsername("username");
        System.out.println(user);
    }

    @Test
    public void testFindByCreateTimeAfter() {
        Pageable pageable = PageRequest.of(1, 10);
        Date createTime = new Date(2018 - 1990, Calendar.FEBRUARY, 24);
        Page<UserDO> page = userRepository.findByCreateTimeAfter(createTime, pageable);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
    }

}
