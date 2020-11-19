package com.zhou.music_admin.service.music.increase;

import com.zhou.music_admin.function.DateProcess;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import javax.annotation.Resource;

@Aspect
@Slf4j
public class musicIncrease {
    @Resource
    private DateProcess dateProcess;
    @Pointcut("execution(* com.zhou.music_admin.service.music.imp.musicControlImp.*(..))")
    public  void  init(){

    }

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before("init()")
    public void beforeMusic(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String path = joinPoint.getSignature()
                .getDeclaringType()
                .getClassLoader()
                .getResource("")
                .getPath();
        //日志记录
        log.info(dateProcess.toFormat("#yyyy-MM-dd HH:mm:SS into"+path+"进行访问"));
    }

    @AfterReturning("init()")
    public void  afterReturning(){

    }

}
