package com.zhou.music_admin.entity.userIdentityBean;

import javax.persistence.*;

@Table(name = "user_identity")
public class UserIdentity {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 身份类型0 1-vip 2-钻石
     */
    private Integer identity;

    /**
     * 用户账号绑定
     */
    private String username;

    /**
     * 有效时间/天
     */
    @Column(name = "identity_data")
    private Integer identityData;

    /**
     * 用户等级
     */
    private Integer grade;

    /**
     * 是否非法 0-否 1-是
     */
    @Column(name = "is_of")
    private Integer isOf;

    @Column(name = "new_column")
    private Integer newColumn;

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
     * 获取身份类型0 1-vip 2-钻石
     *
     * @return identity - 身份类型0 1-vip 2-钻石
     */
    public Integer getIdentity() {
        return identity;
    }

    /**
     * 设置身份类型0 1-vip 2-钻石
     *
     * @param identity 身份类型0 1-vip 2-钻石
     */
    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    /**
     * 获取用户账号绑定
     *
     * @return username - 用户账号绑定
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户账号绑定
     *
     * @param username 用户账号绑定
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取有效时间/天
     *
     * @return identity_data - 有效时间/天
     */
    public Integer getIdentityData() {
        return identityData;
    }

    /**
     * 设置有效时间/天
     *
     * @param identityData 有效时间/天
     */
    public void setIdentityData(Integer identityData) {
        this.identityData = identityData;
    }

    /**
     * 获取用户等级
     *
     * @return grade - 用户等级
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 设置用户等级
     *
     * @param grade 用户等级
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 获取是否非法 0-否 1-是
     *
     * @return is_of - 是否非法 0-否 1-是
     */
    public Integer getIsOf() {
        return isOf;
    }

    /**
     * 设置是否非法 0-否 1-是
     *
     * @param isOf 是否非法 0-否 1-是
     */
    public void setIsOf(Integer isOf) {
        this.isOf = isOf;
    }

    /**
     * @return new_column
     */
    public Integer getNewColumn() {
        return newColumn;
    }

    /**
     * @param newColumn
     */
    public void setNewColumn(Integer newColumn) {
        this.newColumn = newColumn;
    }
}