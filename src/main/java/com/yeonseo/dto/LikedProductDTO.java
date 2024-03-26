package com.yeonseo.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LikedProductDTO {
    private int projectId;
    private String userId;
}
