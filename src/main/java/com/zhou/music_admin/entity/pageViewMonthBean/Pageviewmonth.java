package com.zhou.music_admin.entity.pageViewMonthBean;

import javax.persistence.*;

@Table(name = "pageviewmonth")
public class Pageviewmonth {
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

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取记录时间/天
     *
     * @return index - 记录时间/天
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * 设置记录时间/天
     *
     * @param index 记录时间/天
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * 获取直接访问
     *
     * @return direct - 直接访问
     */
    public Integer getDirect() {
        return direct;
    }

    /**
     * 设置直接访问
     *
     * @param direct 直接访问
     */
    public void setDirect(Integer direct) {
        this.direct = direct;
    }

    /**
     * 获取普通访问
     *
     * @return consumer - 普通访问
     */
    public Integer getConsumer() {
        return consumer;
    }

    /**
     * 设置普通访问
     *
     * @param consumer 普通访问
     */
    public void setConsumer(Integer consumer) {
        this.consumer = consumer;
    }

    /**
     * 获取会员访问
     *
     * @return memberPv - 会员访问
     */
    public Integer getMemberpv() {
        return memberpv;
    }

    /**
     * 设置会员访问
     *
     * @param memberpv 会员访问
     */
    public void setMemberpv(Integer memberpv) {
        this.memberpv = memberpv;
    }

    /**
     * 获取高级会员
     *
     * @return supermenberpv - 高级会员
     */
    public Integer getSupermenberpv() {
        return supermenberpv;
    }

    /**
     * 设置高级会员
     *
     * @param supermenberpv 高级会员
     */
    public void setSupermenberpv(Integer supermenberpv) {
        this.supermenberpv = supermenberpv;
    }

    /**
     * 获取总访问量
     *
     * @return visistor_volume - 总访问量
     */
    public Integer getVisistorVolume() {
        return visistorVolume;
    }

    /**
     * 设置总访问量
     *
     * @param visistorVolume 总访问量
     */
    public void setVisistorVolume(Integer visistorVolume) {
        this.visistorVolume = visistorVolume;
    }

    /**
     * 获取说明
     *
     * @return explain - 说明
     */
    public String getExplain() {
        return explain;
    }

    /**
     * 设置说明
     *
     * @param explain 说明
     */
    public void setExplain(String explain) {
        this.explain = explain;
    }
}