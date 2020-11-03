package com.zhou.music_admin.entity.musicBean;


import lombok.Data;

import java.util.Date;
@Data
public class MusicView {

    private Integer id;

    /**
     * 音乐路径
     */

    private String fileMusic;

    /**
     * 音乐图片路径
     */

    private String fileImg;

    /**
     * 音乐哥名
     */

    private String musicName;

    /**
     * 作者
     */

    private String musicAuthorName;

    /**
     * 上传作者
     */

    private String fileMusicAuthorName;

    /**
     * 音乐组
     */

    private Integer musicType;

    /**
     * 音乐发布时间
     */

    private Date musicData;

    /**
     * 版权到期时间
     */

    private String musicCpyMusicData;

    /**
     * 是否有歌词
     */

    private Integer musicTs;

    /**
     * 歌词
     */

    private String fileLyirc;

    /**
     * 下载等级0-普通  1-vip 3-专卖
     */

    private String musicIndex;

    /**
     * 点击量
     */
    private Integer isPlsy;
}
