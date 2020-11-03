package com.zhou.music_admin.service.managementuserservice;

import com.zhou.music_admin.entity.adminUserBean.AdminRoleUser;
import com.zhou.music_admin.service.managementuserservice.imp.SelToAdminUser;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

public class SelToAdminUserService implements SelToAdminUser {
    @Resource
    AdminRoleUser adminRoleUser;
    @Override
    public AdminRoleUser selOneAdminUser(String username) {

        return null;
    }

    @Override
    public List<AdminRoleUser> selAllAdminUser(String like) {
        return null;
    }

    @Override
    public Set<AdminRoleUser> selRoleAllAdmin(String role) {
        return null;
    }

    @Override
    public Set<AdminRoleUser> selPermsAllAdmin(String perms) {
        return null;
    }
}
