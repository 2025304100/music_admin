package com.zhou.music_admin.entity.titleBean;

import lombok.Builder;
import lombok.Data;


import javax.persistence.*;

@Table(name = "title")
@Builder
@Data
public class Title {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 音乐类型
     */
    private String type;
}