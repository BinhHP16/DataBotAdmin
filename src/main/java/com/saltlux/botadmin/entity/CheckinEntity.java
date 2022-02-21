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
@Table(name = "check_in")
public class CheckinEntity implements Serializable {
    private static final long serialVersionUID = -558553967080513799L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tieu_de")
    private String tieuDe;

    @Column(name = "code")
    private String code;


    @Temporal(TemporalType.TIME)
    @Column(name = "thoi_gian_check_in",columnDefinition = "TIME")
    private Date thoiGianCheckIn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_check_in",columnDefinition = "DATE_TIME")
    private Date ngayCheckIn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userCheckin;
}
