package com.zhou.music_admin.Global;

import com.zhou.music_admin.function.DateProcess;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

@ControllerAdvice
@Slf4j
@Validated
public class ExceptionGlbal {
    @Resource
    private   DateProcess proces;
    @ExceptionHandler(Exception.class)
    public ModelAndView viewError(HttpSession ses,Exception e){
        ModelAndView error = new ModelAndView("error");
        Object username = ses.getAttribute("username");
        String s = proces.toFormat("yyyy年MM月dd日 HH:mm:SS");
        log.debug("异常"+s+":{}",e.getMessage());
        return error;
    }

}
