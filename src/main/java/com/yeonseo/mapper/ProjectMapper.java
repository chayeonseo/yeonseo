package com.yeonseo.mapper;

import com.yeonseo.dto.ProjectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    // 프로젝트 정보 가져오기
    ProjectDTO get_project(int projectId);
}
