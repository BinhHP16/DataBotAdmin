package com.saltlux.botadmin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@JsonIgnoreProperties(
        value = {"thoiGian"},
        allowGetters = true
)
@Table(name = "hom_thu_gop_y")
public class HomThuGopYEntity implements Serializable {
    private static final long serialVersionUID = -558553967080513799L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "noi_dung",columnDefinition = "TEXT")
    private String noiDung;

    @Column(name = "tieu_de")
    private String tieuDe;

    @Column(name = "nguoi_gui")
    private String nguoiGui;

    @Column(name = "status_an_danh")
    private Integer anDanh;

    @CreatedDate
    @Column(name = "thoi_gian")
    private Instant thoiGian;
}
