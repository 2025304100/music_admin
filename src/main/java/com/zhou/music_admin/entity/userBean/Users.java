package com.zhou.music_admin.entity.userBean;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Table(name = "users")
@Builder
@Data
public class Users {
    @Column(name = "USER")
    private String user;

    @Column(name = "CURRENT_CONNECTIONS")
    private Long currentConnections;

    @Column(name = "TOTAL_CONNECTIONS")
    private Long totalConnections;

}