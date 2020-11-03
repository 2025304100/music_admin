package com.zhou.music_admin.entity.adminUserBean;

import lombok.*;

@ToString
@Setter
@Getter
public class AdminRoleUser {
    private Integer id;

    private String username;

    private String password;

    private String roleType;

    private String comment;
}
