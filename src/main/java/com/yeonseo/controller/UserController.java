package com.yeonseo.controller;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/user")


public class UserController {

    @GetMapping("/login")
    public String login_page(){
        return "login";
    }

    @GetMapping("/join")
    public String join_page(){
        return "join";
    }
}
