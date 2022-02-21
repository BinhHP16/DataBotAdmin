package com.saltlux.botadmin.dto.ngayle;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class NgayLeDto {
    private Integer id;
    private String tenNgayLe;
    private String ghiChu;
    private List listNgayle;


}
