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
@Table(name = "lam_them_gio")
public class LamThemGioEntity implements Serializable {
    private static final long serialVersionUID = -558553967080513799L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tieu_de")
    private String tieuDe;

    @Column(name = "ghi_chu",columnDefinition = "TEXT")
    private String ghiChu;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date",columnDefinition = "DATE_TIME")
    private Date date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gio_bat_dau",columnDefinition = "DATE_TIME")
    private Date gioBatDau;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gio_ket_thuc",columnDefinition = "DATE_TIME")
    private Date gioKetThuc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userLamThemGio;
}
