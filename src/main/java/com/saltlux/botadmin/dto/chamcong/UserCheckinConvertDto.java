package com.saltlux.botadmin.dto.chamcong;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserCheckinConvertDto {
    private Integer id;
    private String hoTen;
    private String boPhan;
    private String sdt;
    private String email;
    List listCheckin;
}
