package com.zhou.music_admin.dao.userBean;

import com.zhou.music_admin.entity.userBean.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    /**
     * 建立模糊搜索
     */
    List<User> getSelLikeUser(String key,Integer prefix,Integer suffix);

    List<User> getAllUser(Integer prefix,Integer suffix);
    @Select("select count(`id`) from  `user_` <where> ")
    Long getCount(String like);
}