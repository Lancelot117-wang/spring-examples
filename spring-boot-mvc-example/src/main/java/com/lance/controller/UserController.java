package com.lance.controller;

import com.lance.constants.ServiceExceptionEnum;
import com.lance.dto.UserAddDTO;
import com.lance.dto.UserUpdateDTO;
import com.lance.exception.ServiceException;
import com.lance.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("")
    public List<UserVO> list() {
        List<UserVO> result = new ArrayList<>();
        result.add(new UserVO().setId(1).setUsername("user1"));
        result.add(new UserVO().setId(2).setUsername("user2"));
        result.add(new UserVO().setId(3).setUsername("user3"));
        return result;
    }

    @GetMapping("/{id}")
    public UserVO get(@PathVariable("id") Integer id) {
        return new UserVO().setId(id).setUsername("username:" + id);
    }

    @PostMapping("")
    public Integer add(UserAddDTO addDTO) {
        Integer returnId = 1;
        return returnId;
    }

    @PutMapping("/{id}")
    public Boolean update(@PathVariable("id") Integer id, UserUpdateDTO updateDTO) {
        updateDTO.setId(id);
        Boolean success = true;
        return success;
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        Boolean success = false;
        return success;
    }

    @GetMapping("/exception-01")
    public UserVO exception01() {
        throw new NullPointerException("Null Pointer Exception");
    }

    @GetMapping("/exception-02")
    public UserVO exception02() {
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }
}