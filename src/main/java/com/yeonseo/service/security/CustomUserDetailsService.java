package com.yeonseo.service.security;

import com.yeonseo.dto.UserDTO;
import com.yeonseo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.warn("loadUserByUsername");
        UserDTO userDTO = userMapper.get_user(username);

        if (Objects.isNull(userDTO)){
            throw new UsernameNotFoundException("user가 없다");
        }
        return userDTO;
    }
}
