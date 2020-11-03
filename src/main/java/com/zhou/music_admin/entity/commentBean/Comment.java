package com.zhou.music_admin.entity.commentBean;

import lombok.Builder;
import lombok.Data;


import java.util.Date;
import javax.persistence.*;

@Table(name = "comment")
@Builder
@Data
public class Comment {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 音乐id
     */
    @Column(name = "music_id")
    private Integer musicId;

    /**
     * 评论人账号
     */
    private String profileint;

    /**
     * 追评论账号
     */
    @Column(name = "After_review")
    private String afterReview;

    /**
     * 评论昵称
     */
    @Column(name = "pror_name")
    private String prorName;

    /**
     * 追评昵称
     */
    @Column(name = "after_name")
    private String afterName;

    /**
     * 评论内容
     */
    @Column(name = "profile_text")
    private String profileText;

    /**
     * 点击率
     */
    private Integer click;

    @Column(name = "publish_data")
    private Date publishData;

    /**
     * 图片
     */
    @Column(name = "file_img")
    private String fileImg;

}