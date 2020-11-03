package com.zhou.music_admin.entity.UrlTitleBean;

import javax.persistence.*;

@Table(name = "url_title")
public class UrlTitle {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 路径
     */
    private String url;

    /**
     * 组
     */
    private String groud;

    /**
     * 子
     */
    private String seed;

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
     * 获取路径
     *
     * @return url - 路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置路径
     *
     * @param url 路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取组
     *
     * @return groud - 组
     */
    public String getGroud() {
        return groud;
    }

    /**
     * 设置组
     *
     * @param groud 组
     */
    public void setGroud(String groud) {
        this.groud = groud;
    }

    /**
     * 获取子
     *
     * @return seed - 子
     */
    public String getSeed() {
        return seed;
    }

    /**
     * 设置子
     *
     * @param seed 子
     */
    public void setSeed(String seed) {
        this.seed = seed;
    }
}