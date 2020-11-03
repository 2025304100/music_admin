package com.zhou.music_admin.entity.lyircBean;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "lyirc")

@Data
public class Lyirc {
    @Id
    @GeneratedValue(generator = "JDBC",strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lyirc_name")
    @NotNull(message = "级别内容不能为空!")
    private String lyircName;

    @Column(name = "lyirc_rank")
    @NotNull(message = "级别等级不能为空!")
    private Integer lyircRank;

}