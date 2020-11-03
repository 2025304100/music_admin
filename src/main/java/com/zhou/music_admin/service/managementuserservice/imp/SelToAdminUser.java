package com.zhou.music_admin.service.managementuserservice.imp;

import com.zhou.music_admin.entity.adminUserBean.AdminRoleUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface SelToAdminUser {
    public AdminRoleUser selOneAdminUser(String username);

    public List<AdminRoleUser> selAllAdminUser(String like);

    public Set<AdminRoleUser>  selRoleAllAdmin(String role);

    public Set<AdminRoleUser> selPermsAllAdmin(String perms);
    interface Chain{

    }


}
