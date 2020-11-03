package com.zhou.music_admin.interceptors;


import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class filePorlt implements Filter {
    @Value("${music.hostPath}")
    private String host;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {



    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse rep= (HttpServletResponse) response;
        System.out.println(req.getSession().getId());

        // 允许白名单IP
        rep.setHeader("Access-Control-Allow-Origin", host);
        // 响应类型
        rep.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        rep.setHeader("Access-Control-Allow-Credentials", "true");
        // 预检请求的结果缓存60分钟

        rep.setHeader("Access-Control-Max-Age", "3600");
        // 响应头设置
        rep.setHeader("Access-Control-Allow-Headers", "Accept, Origin, XRequestedWith, Content-Type, LastModified");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {


    }
}
