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
public class DongQuyCongDoanDto {
    private Integer id;
    private Integer soTien;
    private Date ngayDong;
    private String noiDung;


}
