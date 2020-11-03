package com.zhou.music_admin.service.admin.imp;

import com.zhou.music_admin.entity.adminUserBean.AdminUser;
import com.zhou.music_admin.service.ServletMapper;
import com.zhou.music_admin.service.admin.AdminControl;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

public class AdminContolImp extends ServletMapper implements AdminControl {
    @Override
    public List<AdminUser> getAllAdmin() {
        List<AdminUser> adminUsers = adminUserMapper.selectAll();
        if (ObjectUtils.isEmpty(adminUsers))
            adminUsers=new ArrayList<>();
        return adminUsers;
    }

    @Override
    public AdminUser getAdmin(String user) {
        Example example = new Example(AdminUser.class);
        example.createCriteria().andEqualTo("username",user);
        AdminUser adminUser = adminUserMapper.selectOneByExample(example);
        return adminUser;
    }

    @Override
    public List<AdminUser> getIdentityAdmin(String identity) {
        Example example = new Example(AdminUser.class);
        example.createCriteria().andEqualTo("roleType",identity);
        List<AdminUser> adminUsers = adminUserMapper.selectByExample(example);
        if (ObjectUtils.isEmpty(adminUsers))
        adminUsers=new ArrayList<>();
        return adminUsers;
    }

    @Override
    public int insetAdmin(AdminUser adminUser) {
        int insert = adminUserMapper.insert(adminUser);
        return insert;
    }

    @Override
    public int updateAdmin(AdminUser adminUser, String user) {
        Example example = new Example(AdminUser.class);
        example.createCriteria().andEqualTo("username",user);
        int i = adminUserMapper.updateByExample(adminUser, example);
        return i;
    }

    @Override
    public int deleteAdmin(String user) {
        Example example = new Example(AdminUser.class);
        example.createCriteria().andEqualTo("username",user);
        int i = adminUserMapper.deleteByExample(example);
        return i;
    }
}
