package com.zhou.music_admin.controller.comment;

import com.zhou.music_admin.entity.adminUserBean.AdminUser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController

public class Registered {
    @RequestMapping(value = "/system/admin/registered",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public  Map<String,String> addAdminUser(AdminUser user){
        Map<String, String> pt=new HashMap<>();
        return Collections.emptyMap();
    }
}
