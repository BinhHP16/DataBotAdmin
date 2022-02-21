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
@Table(name = "category_tuyen_dung")

public class CategoryTuyenDungEntity implements Serializable {
    private static final long serialVersionUID = -558553967080513799L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "vi_tri")
    private String viTri;


    @Column(name = "code")
    private String code;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "thoi_gian",columnDefinition = "DATE_TIME")
    private Date thoiGian;


    @Column(name = "dia_diem")
    private String diaDiem;


    @Column(name = "muc_luong")
    private String mucLuong;





}
