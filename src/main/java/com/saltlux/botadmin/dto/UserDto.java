package com.saltlux.botadmin.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String hoTen;
    private String boPhan;
    private String gioiTinh;
    private String ngaySinh;
    private String sdt;
    private String email;
    private Integer soNgayNghiPhepTieuChuan;


}
