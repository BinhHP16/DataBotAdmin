package com.saltlux.botadmin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ngay_le")
public class NgayLeEntity implements Serializable {
    private static final long serialVersionUID = -558553967080513799L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "ten_ngay_le")
    private String tenNgayLe;

    @Column(name = "ghi_chu",columnDefinition = "TEXT")
    private String ghiChu;
    @OneToMany(mappedBy="ngayLe")
    private Set<ChiTietNgayLeEntity> listThoiGianNgayLe;
}
