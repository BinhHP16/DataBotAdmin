package com.saltlux.botadmin.dto.cacnoidung;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietNoiDungDto {
    private Integer id;
    private String tieuDe;
    private String thongTinChiTiet;
    private String ghiChu;



}
