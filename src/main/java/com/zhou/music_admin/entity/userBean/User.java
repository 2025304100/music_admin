package com.zhou.music_admin.entity.userBean;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;


import javax.persistence.*;

@Table(name = "user_")
@Data
public class User {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String name;

    private String username;

    private String pas;

    private String sex;

    private String email;

    private String phon;

    @Column(name = "file_img")
    private String fileImg;


}