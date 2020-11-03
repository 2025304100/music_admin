package com.zhou.music_admin.entity.UrlFilterBean;

import javax.persistence.*;

@Table(name = "urlFilter")
public class Urlfilter {
    /**
     * key
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 用户账户
     */
    private String user;

    /**
     * 角色
     */
    private String roles;

    /**
     * 节点id
     */
    private Integer url;

    /**
     * 组
     */
    private String groud;

    /**
     * 获取key
     *
     * @return id - key
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置key
     *
     * @param id key
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户账户
     *
     * @return user - 用户账户
     */
    public String getUser() {
        return user;
    }

    /**
     * 设置用户账户
     *
     * @param user 用户账户
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * 获取角色
     *
     * @return roles - 角色
     */
    public String getRoles() {
        return roles;
    }

    /**
     * 设置角色
     *
     * @param roles 角色
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }

    /**
     * 获取节点id
     *
     * @return url - 节点id
     */
    public Integer getUrl() {
        return url;
    }

    /**
     * 设置节点id
     *
     * @param url 节点id
     */
    public void setUrl(Integer url) {
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
}