package com.zhou.music_admin.service.music;

import com.zhou.music_admin.entity.musicBean.Music;
import com.zhou.music_admin.entity.musicBean.MusicView;
import org.springframework.stereotype.Service;

import java.util.List;


public interface musicControl {
    /**
     * 用户列表
     * @return
     */
    List<Music> getAllMusic();

    /**
     * 用湖列表查询
     * @param index
     * @return
     */
    List<Music> getIndexMusic(Integer index);

    /**
     * 根据作者和歌名的模糊查询
     * @param like_key
     * @return
     */
    List<Music> getLikeMusic(Integer index,String like_key);

    /**
     * 个体查询
     * @param id
     * @return
     */
    Music getOneIdMusic(Integer id);

    /**
     * 音乐修改
     * @param music
     * @return
     */
    int upDateAuthorMusic(Music oldMusic,Music music);

    /**
     * 音乐添加
     * @param music
     * @return
     */
    int insertMusic(Music music);

    /**
     * 删除
     * @param id
     * @return
     */
    int deteleOneMusic(Integer id);

    /**
     * 根据关键字删除
     * @param like_key
     * @return
     */
    int deteleAllMusic(String like_key);

}
