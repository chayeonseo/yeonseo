package com.yeonseo.service;

import com.yeonseo.dto.UserDTO;
import com.yeonseo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void join_user(UserDTO userDTO) {

        userMapper.join_user(userDTO);
    }


    @GetMapping("/join")
    public void user_join(){}

}
