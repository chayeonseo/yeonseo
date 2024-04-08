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
    private String name; // 원본 파일명
    private String type; // 원본 파일의 타입
    private String detail; // 원본 데이터
    private int order; // 순번
}
