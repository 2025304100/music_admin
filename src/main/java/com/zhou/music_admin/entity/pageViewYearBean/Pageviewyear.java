package com.zhou.music_admin.entity.pageViewYearBean;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Table(name = "pageviewyear")
@Builder
@Data
public class Pageviewyear {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 记录时间/天
     */
    private Integer index;

    /**
     * 直接访问
     */
    private Integer direct;

    /**
     * 普通访问
     */
    private Integer consumer;

    /**
     * 会员访问
     */
    @Column(name = "memberPv")
    private Integer memberpv;

    /**
     * 高级会员
     */
    private Integer supermenberpv;

    /**
     * 总访问量
     */
    @Column(name = "visistor_volume")
    private Integer visistorVolume;

    /**
     * 说明
     */
    private String explain;
}