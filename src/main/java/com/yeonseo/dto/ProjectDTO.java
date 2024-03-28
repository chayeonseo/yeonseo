package com.yeonseo.dto;

import lombok.*;

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
    private String thumbImage;
    private CategoryDTO category;
    private int goal;
    private UserDTO createUser;
    private String summary;
    private int price;
    private int delivery;
    private Date startDate;
    private Date endDate;
    private List<ProjectDetailDTO> details;
    private List<UserDTO> members;
}
