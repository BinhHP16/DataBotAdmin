package com.saltlux.botadmin.dto.cacnoidung;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class NoiDungChungDto {
    private Integer id;
    private String category;
    private String ten_noi_dung;
    private String code;


    public NoiDungChungDto(int id, String category, String ten_noi_dung, String code) {
        this.id = id;
        this.category = category;
        this.ten_noi_dung = ten_noi_dung;
        this.code = code;
    }
}
