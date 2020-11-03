package com.zhou.music_admin.service.managementuserservice.imp;

import com.zhou.music_admin.entity.adminUserBean.AdminUser;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface TransferToAdmin {
    public int upDataAdminUser(String key, AdminUser adminUser);

    public int upDataMapAdminUser(Map<String, String> admin,AdminUser adminUser);

    public int insertAdminUser(AdminUser adminUser);

    public int delteAdminUser(String key);


}
