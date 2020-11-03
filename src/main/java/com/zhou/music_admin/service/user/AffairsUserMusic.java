package com.zhou.music_admin.service.user;


import com.zhou.music_admin.entity.userMusicBean.UserMusic;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AffairsUserMusic {
    /**
     * 用湖收藏音乐查询
     * @param username 用户名
     * @return
     */
    List<UserMusic> getSelUserMusic(String username);


    /**
     * 用户收藏删除
     * @param username
     * @return
     */
    int deleteUserMusic(String username);
}
