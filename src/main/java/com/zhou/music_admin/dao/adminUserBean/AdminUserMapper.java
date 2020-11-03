package com.zhou.music_admin.dao.adminUserBean;

import com.zhou.music_admin.entity.adminUserBean.AdminUser;
import com.zhou.music_admin.entity.adminUserBean.AdminRoleUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface AdminUserMapper extends Mapper<AdminUser> {

    AdminRoleUser getAdminView(@Param("username") String user);
}