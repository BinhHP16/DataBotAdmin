package com.saltlux.botadmin.dto.congdoan;

import com.saltlux.botadmin.dto.UserDto;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class CacKhoanChiPhiDto {
    private Integer id;
    private String noiDung;
    private Integer soTien;
    private Date date;
    private String ghiChu;

}
