package com.zhou.music_admin.service;

import com.zhou.music_admin.dao.adminUserBean.AdminUserMapper;
import com.zhou.music_admin.entity.adminUserBean.AdminRoleUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminUserService {


    @Resource
    AdminUserMapper adminUserMapper;
    public AdminRoleUser getAdmusicUserView(String user){

       return adminUserMapper.getAdminView(user);
    }


}
