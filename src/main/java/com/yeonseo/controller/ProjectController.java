package com.yeonseo.controller;

import com.yeonseo.dto.ProjectDTO;
import com.yeonseo.service.ProjectService;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/{projectId}")
    public String get_project_info(
            @PathVariable int projectId,
            Model model
    ){
        // 검색 조건에 맞는 프로젝트의 정보 조회
        ProjectDTO projectDTO = projectService.get_project(projectId);
        model.addAttribute("project", projectDTO);
        return "product";
    }

}
