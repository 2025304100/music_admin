package com.zhou.music_admin.dao.userMusicBean;

import com.zhou.music_admin.entity.userMusicBean.UserMusic;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMusicMapper extends Mapper<UserMusic> {
    List<UserMusic> getSelUserMusic(String username);
}