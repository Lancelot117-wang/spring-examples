package com.lance.repository;

import com.lance.entity.UserDO;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository01 extends CrudRepository<UserDO, Integer> {
    void findByUsername(String username);
}
