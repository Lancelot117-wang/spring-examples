package com.lance.repository;

import com.lance.entity.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest04 {

    @Autowired
    private UserRepository04 userRepository;

    @Test
    public void testFindIdByUsername01() {
        UserDO user = userRepository.findByUsername01("username01");
        System.out.println(user);
    }

    @Test
    public void testFindIdByUsername02() {
        UserDO user = userRepository.findByUsername02("username02");
        System.out.println(user);
    }

    @Test
    public void testFindIdByUsername03() {
        UserDO user = userRepository.findByUsername03("username03");
        System.out.println(user);
    }

    @Test
    @Transactional
    public void testUpdateUsernameById() {
        userRepository.updateUsernameById(5, "username");
    }

}
