package com.zhou.music_admin.controller;


import com.zhou.music_admin.monitor.Resource;
import com.zhou.music_admin.monitor.ResourceC;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.awt.*;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/resource",produces = MediaType.APPLICATION_JSON_VALUE)
@NoArgsConstructor(onConstructor = @__(@Autowired))
public class ResourceController {
    @RequestMapping("/hardware")
    public Map<String,String> getExceptionResource(ResourceC c){

        Resource resource = c.toExceptionResource();
        Map<String, String> huoqu = resource.get_Huoqu();
        System.out.println("#############################"+huoqu.get("cpu")+"###############################");
        huoqu.forEach((e,v)-> System.out.println(e+"#:#"+v));
        return huoqu;
    }
}
