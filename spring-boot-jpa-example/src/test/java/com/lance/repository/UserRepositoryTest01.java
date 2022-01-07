package com.lance.repository;

import com.lance.Application;
import com.lance.entity.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTest01 {

    @Autowired
    private UserRepository01 userRepository;

    @Test
    public void testInsert() {
        UserDO user = new UserDO().setUsername("username1")
                .setPassword("password1").setCreateTime(new Date());
        userRepository.save(user);
    }

    @Test
    public void testUpdateById() {
        UserDO updateUser = new UserDO().setId(1).setUsername("username2")
                .setPassword("password2").setCreateTime(new Date());
        userRepository.save(updateUser);
    }

    @Test
    public void testDeleteById() {
        UserDO user = new UserDO().setId(2).setUsername("username")
                .setPassword("password").setCreateTime(new Date());
        userRepository.save(user);
        userRepository.deleteById(2);
    }

    @Test
    public void testSelectById() {
        userRepository.findById(1);
    }

    @Test
    public void testSelectByUsername() {
        userRepository.findByUsername("username");
    }

    @Test
    public void testSelectByIds() {
        Iterable<UserDO> users = userRepository.findAllById(Arrays.asList(1, 3));
        AtomicInteger count = new AtomicInteger();
        users.forEach(e -> count.getAndIncrement());
        System.out.println("users：" + count.get());
    }

}
