package com.yeonseo.service;

import com.yeonseo.dto.ProjectDTO;
import com.yeonseo.dto.ProjectDetailDTO;
import com.yeonseo.mapper.ProjectMapper;
import com.yeonseo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectMapper projectMapper;

    public List<ProjectDTO> view_home(){
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

//        result.forEach(x -> {
//            System.out.println(x.getId());
//            System.out.println(x.getCount());
//            System.out.println();
//
//        });

        System.out.println("a:" +result.size());
        List<ProjectDTO> subResult = result.subList(0, 8);

        System.out.println("b:" +subResult.size());
        return subResult;
    };

    public ProjectDTO get_project(int projectId){
        return projectMapper.get_project(projectId);
    }

    public void like_project(int projectId, String userId){
        projectMapper.like_project(projectId, userId);
    }

    @Transactional
    public void insert_project(ProjectDTO projectDTO){
        // 프로젝트 하나 insert
        projectMapper.insert_project(projectDTO);
        // 프로젝트 detail insert
        projectMapper.insert_project_details(projectDTO);
    };
}
