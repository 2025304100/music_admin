package com.zhou.music_admin.dao.userIdentityBean;


import com.zhou.music_admin.entity.userIdentityBean.UserIdentity;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserIdentityMapper extends Mapper<UserIdentity> {
     List<UserIdentity> getLikeIdentity(String link,Integer prefix,Integer suffix);

     List<UserIdentity> getAllIdentity(Integer prefix,Integer suffix);
     @Select("select count(`id`) from `user_identity`")
     Long getCount(String like);
}