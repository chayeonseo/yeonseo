package com.yeonseo.mapper;

import com.yeonseo.dto.ProjectDTO;
import com.yeonseo.dto.ProjectDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    // 메인 화면 프로젝트 정보 가져오기
    List<ProjectDTO> view_home();

    // 개별 프로젝트 정보 가져오기
    ProjectDTO get_project(int projectId);

    void like_project(int projectId, String userId);

    void insert_project(ProjectDTO projectDTO);
    void insert_project_details(ProjectDTO projectDTO);
}
