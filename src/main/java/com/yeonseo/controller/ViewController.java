package com.yeonseo.controller;

import com.yeonseo.dto.ProjectDTO;
import com.yeonseo.service.ProjectService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Controller
public class ViewController {
    @Autowired ProjectService projectService;

    @GetMapping("/home")
    public String view_home(Model model){
        model.addAttribute("projects", projectService.view_home());
//        System.out.println(model);
        return "home";
    }


}








