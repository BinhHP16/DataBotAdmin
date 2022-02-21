package com.saltlux.botadmin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -558553967080513799L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "bo_phan")
    private String boPhan;

    @Column(name = "gioi_tinh")
    private String gioiTinh;

    @Column(name = "ngay_sinh")
    private String ngaySinh;

    @Column(name = "so_dien_thoai")
    private String sdt;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "so_ngay_nghi_phep_tieu_chuan")
    private Integer soNgayNghiPhepTieuChuan;

    @OneToMany(mappedBy = "userCheckin")
    private List<CheckinEntity> listCheckin;

    @OneToMany(mappedBy="userNghiPhep")
    private List<NgayNghiPhepEntity> listNgayNghiPhep;

    @OneToMany(mappedBy="userLamThemGio")
    private List<LamThemGioEntity> listLamThemGio;

    @OneToMany(mappedBy="userDongQuy")
    private List<DongQuyCongDoanEntity> listDongQuy;

}
