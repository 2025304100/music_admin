package com.zhou.music_admin.service.role.imp;

import com.zhou.music_admin.entity.UserRoleBean.UserRole;
import com.zhou.music_admin.service.ServletMapper;
import com.zhou.music_admin.service.role.RoleControl;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleControlImp extends ServletMapper implements RoleControl {
    @Override
    public List<UserRole> getAllUserRole() {
        List<UserRole> userRoles = userRoleMapper.selectAll();
        if (ObjectUtils.isEmpty(userRoles))
            userRoles=new ArrayList<>();
        return userRoles;
    }

    @Override
    public UserRole getOneRoleUserRole(String role) {
        Example example = new Example(UserRole.class);
        example.createCriteria().andEqualTo("roleType",role);
        UserRole userRole = userRoleMapper.selectOneByExample(example);
        if (ObjectUtils.isEmpty(userRole))
            userRole=new UserRole();
        return userRole;
    }

    @Override
    public UserRole getOneKeyUserRole(Integer id) {
        Example example = new Example(UserRole.class);
        example.createCriteria().andEqualTo("id",id);
        UserRole userRole = userRoleMapper.selectOneByExample(example);
        if (ObjectUtils.isEmpty(userRole))
            userRole=new UserRole();
        return userRole;
    }

    @Override
    public int upDateUserRole(UserRole userRole, Integer id) {
            userRole.setId(id);
        int i = userRoleMapper.updateByPrimaryKey(userRole);
        return i;
    }

    @Override
    public int insertUserRole(UserRole userRole) {
        int insert = userRoleMapper.insert(userRole);
        return insert;
    }

    @Override
    public int deleteUserRole(UserRole userRole) {
        int delete = userRoleMapper.delete(userRole);
        return delete;
    }
}
