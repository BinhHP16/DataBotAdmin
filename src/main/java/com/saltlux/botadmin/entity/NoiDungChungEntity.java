package com.saltlux.botadmin.entity;

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
@Table(name = "noi_dung_chung")
public class NoiDungChungEntity implements Serializable {
    private static final long serialVersionUID = -558553967080513799L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category")
    private String category;

    @Column(name = "ten_noi_dung")
    private String tenNoiDungChung;

    @Column(name = "ghi_chu",columnDefinition = "TEXT")
    private String ghiChu;

    @Column(name = "code")
    private String code;
}
