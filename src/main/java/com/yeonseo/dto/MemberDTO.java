package com.yeonseo.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private int projectId;
    public String userId;
}
