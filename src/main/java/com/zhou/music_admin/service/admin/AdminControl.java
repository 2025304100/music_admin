package com.zhou.music_admin.service.admin;

import com.zhou.music_admin.entity.adminUserBean.AdminUser;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminControl {

    List<AdminUser> getAllAdmin();

    AdminUser getAdmin(String user);

    List<AdminUser> getIdentityAdmin(String identity);

    int insetAdmin(AdminUser adminUser);

    int updateAdmin(AdminUser adminUser,String user);

    int deleteAdmin(String user);
}
