package com.saltlux.botadmin.dto.lamthemgio;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserLamThemGioDto {
    private Integer id;
    private String ho_ten;
    private String boPhan;
    List listLamThemGio;



}
