package com.saltlux.botadmin.dto.ngaynghiphep;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserNgayNghiPhepDto {
    private Integer id;
    private String hoTen;
    private Integer soNgayNghiPhepTieuChuan;
    private String boPhan;
    List listNgayNghiPhep;
    private Double soNgayDaNghi;
    private Double soNgayNghiPhepConLai;

}
