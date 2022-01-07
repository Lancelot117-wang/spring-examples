package com.lance.repository;

import com.lance.entity.UserDO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository02 extends PagingAndSortingRepository<UserDO, Integer> {

}