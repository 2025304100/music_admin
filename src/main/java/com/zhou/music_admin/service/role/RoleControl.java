package com.zhou.music_admin.service.role;

import com.zhou.music_admin.entity.UserRoleBean.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleControl {
     List<UserRole> getAllUserRole();

     UserRole getOneRoleUserRole(String role);

     UserRole getOneKeyUserRole(Integer id);

     int upDateUserRole(UserRole userRole,Integer id);

     int insertUserRole(UserRole userRole);

     int deleteUserRole(UserRole userRole);
}
