package com.zhou.music_admin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;

@Configuration
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class errorView {
    public ModelAndView jursdictionView(ModelAndView mo){
        mo.setViewName("unauthor");
        mo.getModel().put("error","你无权访问");
        mo.getModel().put("tis","401");
        return  mo;
    }
}
