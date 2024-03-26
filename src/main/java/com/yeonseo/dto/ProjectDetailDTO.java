package com.yeonseo.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDetailDTO {
    private int no;
    private int projectId;
    private String detail;
    private int order;
}
