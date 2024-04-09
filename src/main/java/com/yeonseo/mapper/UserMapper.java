package com.yeonseo.mapper;

import com.yeonseo.dto.ProjectDTO;
import com.yeonseo.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void join_user(UserDTO userDTO);
}
