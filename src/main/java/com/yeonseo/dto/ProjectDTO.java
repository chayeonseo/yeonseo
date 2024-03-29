package com.yeonseo.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO         {
    private int id;
    private String title;
    private ProjectDetailDTO thumbImage;
    private CategoryDTO category;
    private int goal;
    private UserDTO createUser;
    private String summary;
    private int price;
    private int status;
    private int delivery;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private List<ProjectDetailDTO> details;
    private List<UserDTO> members;
}
