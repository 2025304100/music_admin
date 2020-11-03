package com.zhou.music_admin.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.zhou.music_admin.security_module.ShiroFileChainManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping(value = "/index",produces = MediaType.APPLICATION_JSON_VALUE)
public class loginIndex {
    @Value("${music.hostPath}")
    private String host;
    @Autowired
    ShiroFileChainManager shiroFileChainManager;
    @Autowired
    ShiroFilterFactoryBean shiroFilterFactoryBean;
    @GetMapping("/login")
    public String dmeo(){
        return "login";
    }
    @PostMapping("/toLogin")
    public @ResponseBody String login(HttpSession session, String username, String password){
        Subject subject = SecurityUtils.getSubject();
        log.info("账号 username={}password={}",username,password);
        if (!subject.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            try {
                subject.login(token);
               log.info("-----------刷新用户url成功!---------------");
                shiroFileChainManager.upDataFilterChainManager(username,shiroFilterFactoryBean,true);
                session.setAttribute("username",username);
               return "0";
            }catch (AuthenticationException e){
                log.debug(e.getMessage());
                return "-1";
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return "-3";
    }
}
