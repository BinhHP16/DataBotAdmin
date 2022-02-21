package com.saltlux.botadmin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "chi_tiet_noi_dung")
public class ChiTietNoiDungEntity implements Serializable {
    private static final long serialVersionUID = -558553967080513799L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tieu_de")
    private String tieuDe;

    @Column(name = "thong_tin_chi_tiet",columnDefinition = "TEXT")
    private String thongTinChiTiet;

    @Column(name = "ghi_chu",columnDefinition = "TEXT")
    private String ghiChu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "noi_dung_chung_id", nullable = false)
    @JsonIgnore
    private NoiDungChungEntity noiDungChung;
}
