package com.zhou.music_admin.entity.adminUserBean;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Table(name = "admin_user")
@Data
@Builder
public class AdminUser {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String username;

    /**
     * 密码
     */
    private String pas;

    /**
     * 0-一般权限   1-- 2   
     */
    @Column(name = "role_type")
    private Integer roleType;

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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return pas - 密码
     */
    public String getPas() {
        return pas;
    }

    /**
     * 设置密码
     *
     * @param pas 密码
     */
    public void setPas(String pas) {
        this.pas = pas;
    }

    /**
     * 获取0-一般权限   1-- 2   
     *
     * @return role_type - 0-一般权限   1-- 2   
     */
    public Integer getRoleType() {
        return roleType;
    }

    /**
     * 设置0-一般权限   1-- 2   
     *
     * @param roleType 0-一般权限   1-- 2   
     */
    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }
}