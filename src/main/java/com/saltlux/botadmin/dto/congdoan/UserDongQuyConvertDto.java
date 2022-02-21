package com.saltlux.botadmin.dto.congdoan;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserDongQuyConvertDto {
    private Integer id;
    private String hoTen;
    private String boPhan;
    private String sdt;
    private String email;
    private Integer tongTien;
    List listDongQuy;

    public UserDongQuyConvertDto(Integer id, String hoTen, String boPhan, String sdt, String email, List listDongQuy) {
        this.id = id;
        this.hoTen = hoTen;
        this.boPhan = boPhan;
        this.sdt = sdt;
        this.email = email;
        this.listDongQuy = listDongQuy;
    }
}
