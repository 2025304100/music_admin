package com.zhou.music_admin.entity.mtypeBean;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "mtype")
@Data
public class Mtype {
    @Id
    @GeneratedValue(generator = "JDBC",strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 音乐类型
     */
    @Column(name = "musictypeZh")
    @NotNull(message = "音乐类型不能为空!")
    private String musictypezh;

    /**
     * 音乐编号
     */
    @Column(name = "music_type")
    @NotNull(message = "音乐编号不能为空!")
    private String musicType;

}