package com.saltlux.botadmin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "thong_tin_tuyen_dung")

public class ThongTinTuyenDungEntity {
    private static final long serialVersionUID = -558553967080513799L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "tieu_de")
    private String tieuDe;

    @Column(name = "noi_dung",columnDefinition = "TEXT")
    private String noiDung;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryTuyenDungEntity category;
}
