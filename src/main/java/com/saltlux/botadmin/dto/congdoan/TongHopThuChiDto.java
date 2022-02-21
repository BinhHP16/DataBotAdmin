package com.saltlux.botadmin.dto.congdoan;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class TongHopThuChiDto {
    private Integer soDuDauNam;
    private Integer khoanThu;
    private Integer khoanChi;

}
