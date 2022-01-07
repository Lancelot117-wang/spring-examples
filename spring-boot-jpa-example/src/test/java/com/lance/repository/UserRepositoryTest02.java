package com.lance.repository;

import com.lance.entity.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest02 {

    @Autowired
    private UserRepository02 userRepository;

    @Test
    public void testFindAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Iterable<UserDO> iterable = userRepository.findAll(sort);
        iterable.forEach(System.out::println);
    }

    @Test
    public void testFindPage() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(1, 10, sort);
        Page<UserDO> page = userRepository.findAll(pageable);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
    }

}
