package com.zhou.music_admin.service;

import com.zhou.music_admin.dao.userBean.UserMapper;
import com.zhou.music_admin.entity.userIdentityBean.UserIdentity;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service

public class UserControl {
    @Resource
    private UserMapper userMapper;


}
