package com.yeonseo.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    public String id;
    public String name;
    public String email;
    public String pw;
    public String addr1;
    public String addr2;
    public String profilePhoto;
}
