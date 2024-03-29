package com.yeonseo.service;

import com.yeonseo.dto.ProjectDTO;
import com.yeonseo.mapper.ProjectMapper;
import com.yeonseo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectMapper projectMapper;

    private List<ProjectDTO> view_project(){return projectMapper.view_project();};

    public ProjectDTO get_project(int projectId){
        return projectMapper.get_project(projectId);
    }

    public void like_project(int projectId, String userId){
        projectMapper.like_project(projectId, userId);
    }

    public void insert_project(ProjectDTO projectDTO){
        projectMapper.insert_project(projectDTO);
    };
}
