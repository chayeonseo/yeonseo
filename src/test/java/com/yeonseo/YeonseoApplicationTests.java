package com.yeonseo;

import com.yeonseo.dto.ProjectDTO;
import com.yeonseo.mapper.ProjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.List;

@SpringBootTest
class YeonseoApplicationTests {
    @Autowired
    ProjectMapper projectMapper;

    @Test
    void contextLoads() {
        List<ProjectDTO> result = projectMapper.view_home();
        for (ProjectDTO a : result) {
            a.setCount(a.getMembers().size());
        }

        result.sort(new Comparator<ProjectDTO>() {
            @Override
            public int compare(ProjectDTO o1, ProjectDTO o2) {
                return o2.getCount() - o1.getCount();
            }
        });
        result.forEach(x -> {
            System.out.println(x.getId());
            System.out.println(x.getCount());
            System.out.println();
        });

    }



}
