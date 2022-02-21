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
@Table(name = "dong_quy_cong_doan")
public class DongQuyCongDoanEntity implements Serializable {
    private static final long serialVersionUID = -558553967080513799L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "so_tien")
    private Integer soTien;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_dong",columnDefinition = "DATE_TIME")
    private Date ngayDong;

    @Column(name = "noi_dung",columnDefinition = "TEXT")
    private String noiDung;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userDongQuy;
}
