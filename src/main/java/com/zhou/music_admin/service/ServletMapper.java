package com.zhou.music_admin.service;

import com.zhou.music_admin.dao.UserRoleBean.UserRoleMapper;
import com.zhou.music_admin.dao.adminUserBean.AdminUserMapper;
import com.zhou.music_admin.dao.lyircBean.LyircMapper;
import com.zhou.music_admin.dao.mtypeBean.MtypeMapper;
import com.zhou.music_admin.dao.musicBean.MusicMapper;
import com.zhou.music_admin.dao.userBean.UserMapper;


import com.zhou.music_admin.dao.userIdentityBean.UserIdentityMapper;
import com.zhou.music_admin.dao.userMusicBean.UserMusicMapper;
import com.zhou.music_admin.entity.mtypeBean.Mtype;
import org.springframework.beans.factory.annotation.Configurable;

import javax.annotation.Resource;

@Configurable
public class ServletMapper {
    @Resource
    public  UserMapper userMapper;
    @Resource
    public UserIdentityMapper userIdentityMapper;
    @Resource
    public AdminUserMapper  adminUserMapper;
    @Resource
    public UserRoleMapper userRoleMapper;
    @Resource
    public MusicMapper musicMapper;
    @Resource
    public UserMusicMapper userMusicMapper;
    @Resource
    public MtypeMapper mtypeMapper;
    @Resource
    public LyircMapper lyircMapper;

}
