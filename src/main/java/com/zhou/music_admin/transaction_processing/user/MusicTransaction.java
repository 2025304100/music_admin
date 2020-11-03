package com.zhou.music_admin.transaction_processing.user;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MusicTransaction {
    @Pointcut("execution(* com.zhou.music_admin.service.user.imp.UserControlImp.*(..))")
    private void InTo(){
        log.trace("ww");
    }

}
