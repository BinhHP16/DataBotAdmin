package com.saltlux.botadmin.dto.ngaynghiphep;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class NgayNghiPhepConvertDto {
    private Integer id;
    private Date ngayNghi;
    private Double manDay;
}
