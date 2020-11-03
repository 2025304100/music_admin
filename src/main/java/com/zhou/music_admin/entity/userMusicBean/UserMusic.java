package com.zhou.music_admin.entity.userMusicBean;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Builder
@Data
@Table(name = "user_music")
public class UserMusic {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 用户听过的音乐的id
     */
    @Id
    private String username;

    @Id
    @Column(name = "music_id")
    private Integer musicId;

    /**
     * 是否购买过
     */
    @Column(name = "is_buy")
    private Integer isBuy;

    @Column(name = "data_time")
    private Date dataTime;

}