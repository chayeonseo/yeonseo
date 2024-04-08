package com.yeonseo;

import com.yeonseo.mapper.ProjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YeonseoApplicationTests {
    @Autowired
    ProjectMapper projectMapper;

    @Test
    void contextLoads() {
        System.out.println(projectMapper.view_home().get(0));
    }



}
