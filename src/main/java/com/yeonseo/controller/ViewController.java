package com.yeonseo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Controller
public class ViewController {
    private String BASE_DIR = "C:\\yeonseo";

    @GetMapping("/img/{projectId}/{imageName}")
    public byte[] get_image(
            @PathVariable Integer projectId,
            @PathVariable String imageName
    ) throws Exception {
        File file = new File(BASE_DIR + projectId + "\\" + imageName);
        byte[] imageBytes = new FileInputStream(file).readAllBytes();
        return imageBytes;
    }
}








