package com.zhou.music_admin.transaction_processing.user;

import com.zhou.music_admin.entity.userBean.User;
import com.zhou.music_admin.entity.userIdentityBean.UserIdentity;
import com.zhou.music_admin.function.DateProcess;
import jdk.nashorn.internal.scripts.JO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
@Slf4j
@NoArgsConstructor(onConstructor =@__(@Autowired))
public class UserTransaction {
    @Autowired
    private  DateProcess dateProcess;
    @Pointcut("execution(* com.zhou.music_admin.service.user.imp.UserControlImp.*(..))")
    public void InTo(){
      log.trace("ww");
    }
    //信息处理防空处理
    @Before("InTo()")
    public void  deBefore(JoinPoint joinPoint) {
        //信息方法内容
        Object[] args = joinPoint.getArgs();
        //获取方法模组
        Signature signature = joinPoint.getSignature();
        signature.getName();
        if (args.length == 0) {
            return;
        }
        int i=0;
        for (Object o : args) {
            if (o instanceof User) {
                User us = (User) o;

                String s = us.toString();
                if (s.contains("null")) {
                    us.setId(-2);
                    log.warn(signature.getDeclaringTypeName()
                            +signature.getName()+"第"+i+"传输NULL");
                    throw new NullPointerException(signature.getDeclaringTypeName()
                            +signature.getName()+"第"+i+"传输NULL");
                     }
                }else  if(o instanceof String){
                String str= (String) o;
                //获取方法名
                String name=joinPoint.getSignature().getName();
                if (StringUtils.isEmpty(str)&&name.equals("getUserCount")&&name.equals("getCount")){
                    //初始化
                    str="";
                    log.warn(signature.getDeclaringTypeName()
                            +signature.getName()+"第"+i+"传输{}",str);
                    throw new NullPointerException(signature.getDeclaringTypeName()
                            +signature.getName()+"第"+i+"传输NULL");
                     }
                }else if (o instanceof UserIdentity){
                UserIdentity us= (UserIdentity) o;
                String s = us.toString();
                if (s.contains("null")) {
                    us.setId(-2);
                    log.warn(signature.getDeclaringTypeName()
                            +signature.getName()+"第"+i+"传输NULL");
                    throw new NullPointerException(signature.getDeclaringTypeName()
                            +signature.getName()+"传入的值为null");
                }
                i++;
            }

        }
    }
    @Before("InTo()")
    public void  recordingLog(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();

        log.info(dateProcess.toFormat("yyyy年MM月dd日  HH:mm:ss:SSS")
                +"--"+signature.getDeclaringTypeName()+"##"
                +signature.getName());
    }
    //返回通知
    @AfterReturning(value = "InTo()",returning = "returnings")
    public Object getRetuning(JoinPoint joinPoint,Object returnings){
        return  returnings;
    }
    //异常通知


}

