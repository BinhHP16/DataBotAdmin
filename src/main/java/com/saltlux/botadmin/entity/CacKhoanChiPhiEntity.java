package com.saltlux.botadmin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cac_khoan_chi_phi")
public class CacKhoanChiPhiEntity implements Serializable {
    private static final long serialVersionUID = -558553967080513799L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "so_tien")
    private Integer soTien;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "thoi_gian",columnDefinition = "DATE_TIME")
    private Date thoiGian;

    @Column(name = "ghi_chu",columnDefinition = "TEXT")
    private String ghiChu;

}
