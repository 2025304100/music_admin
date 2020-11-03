package com.zhou.music_admin.entity.musicBean;

import lombok.Builder;
import lombok.Data;


import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Table(name = "music")

@Data
public class Music {
    @Id
    @NotNull(message = "NotNull不能为空")
    @Min(value = 1,message = "输入的数必须为正整数")
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    /**
     * 音乐路径
     */
    @Column(name = "file_music")
    @NotNull(message = "音乐路径不能为空")
    private String fileMusic;

    /**
     * 音乐图片路径
     */
    @Column(name = "file_img")
    @NotNull(message = "图片资源不能为空")
    private String fileImg;

    /**
     * 音乐哥名
     */
    @Column(name = "music_name")
    @NotNull(message = "音乐歌名不能为空")
    private String musicName;

    /**
     * 作者
     */
    @Column(name = "music_author_name")
    @NotNull(message = "作者不能为空")
    private String musicAuthorName;

    /**
     * 上传作者
     */
    @Column(name = "file_music_author_name")
    @NotNull(message = "上传者不能为空")
    private String fileMusicAuthorName;

    /**
     * 音乐组
     */
    @Column(name = "music_type")
    @NotNull(message = "音乐组不能为空")
    private Integer musicType;

    /**
     * 音乐发布时间
     */
    @Column(name = "music_data")
    @NotNull(message = "音乐上传时间不能为空")
    private Date musicData;

    /**
     * 版权到期时间
     */
    @Column(name = "music_cpy_music_data")
    @NotNull(message = "版权时间不能为空")
    private String musicCpyMusicData;

    /**
     * 是否有歌词
     */
    @Column(name = "music_ts")
    @NotNull(message = "标记不能为空")
    private Integer musicTs;

    /**
     * 歌词
     */
    @Column(name = "file_lyirc")

    private String fileLyirc;

    /**
     * 下载等级0-普通  1-vip 3-专卖
     */
    @Column(name = "music_index")
    @NotNull(message = "音乐级不能为空")
    private Integer musicIndex;

    /**
     * 点击量
     */
    private Integer context;

    @Column(name = "is_plsy")

    private Integer isPlsy;

}