package com.saltlux.botadmin.dto.chamcong;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ChamCongDto {
    private String hoTen;
    private String thoiGian;
    private Double nghiPhep;
    private long diMuon;
   private Double ngayCong;

    public ChamCongDto(String hoTen, String thoiGian, Double nghiPhep, long diMuon) {
        this.hoTen = hoTen;
        this.thoiGian = thoiGian;
        this.nghiPhep = nghiPhep;
        this.diMuon = diMuon;
    }
}
