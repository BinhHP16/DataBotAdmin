package com.saltlux.botadmin.dto.lamthemgio;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class LamThemGioConvertDto {
    private Integer id;
    private String tieuDe;
    private String ghiChu;
    private Date date;
    private Date gioBatDau;
    private Date gioKetThuc;
}
