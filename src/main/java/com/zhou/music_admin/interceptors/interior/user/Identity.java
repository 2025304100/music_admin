package com.zhou.music_admin.interceptors.interior.user;

import com.zhou.music_admin.service.user.imp.UserControlImp;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Identity implements HandlerInterceptor {
    @Resource
    private UserControlImp userControlImp;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //基本配置信息
        HttpSession session = request.getSession();
        Object
                user_count=  session.getAttribute("user_count"),
                identity_count=session.getAttribute("identity_count");
        if(ObjectUtils.isEmpty(user_count)){
            session.setAttribute("music_count",userControlImp.getUserCount(null));
        }
        if (ObjectUtils.isEmpty(identity_count)){
            session.setAttribute("identity_count",userControlImp.getCount(null));
        }



        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
