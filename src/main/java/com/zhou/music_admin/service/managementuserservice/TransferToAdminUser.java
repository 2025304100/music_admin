package com.zhou.music_admin.service.managementuserservice;

import com.zhou.music_admin.dao.adminUserBean.AdminUserMapper;
import com.zhou.music_admin.entity.adminUserBean.AdminUser;
import com.zhou.music_admin.service.managementuserservice.imp.TransferToAdmin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Map;


@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransferToAdminUser implements TransferToAdmin {
  @Resource
    AdminUserMapper adminUserMapper;

    @Override
    public int upDataAdminUser(String key, AdminUser adminUser) {

        return 0;
    }

    @Override
    public int upDataMapAdminUser(Map<String, String> admin, AdminUser adminUser) {
        return 0;
    }

    @Override
    public int insertAdminUser(AdminUser adminUser) {
        return 0;
    }

    @Override
    public int delteAdminUser(String key) {
        return 0;
    }
}
