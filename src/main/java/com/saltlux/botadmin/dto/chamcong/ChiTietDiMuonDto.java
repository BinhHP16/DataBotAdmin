package com.saltlux.botadmin.dto.chamcong;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietDiMuonDto {
    private String thoiGian;
    private Date ngay;
    private long diMuon;
}
