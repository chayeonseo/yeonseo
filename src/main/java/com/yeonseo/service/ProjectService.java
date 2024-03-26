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
    public ProjectDTO get_project(int projectId){
        return projectMapper.get_project(projectId);
    }
}
