package com.zhou.music_admin.View.resource.Enhance;

import com.zhou.music_admin.security_module.encryption_model.Base64;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
@Slf4j
public class IoImg {
    @Pointcut("execution(* com.zhou.music_admin.View.resource.InputImg.*(..))    ")
    private void Mi() {
    }
    @Before("Mi()")
    private void prcoess(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        for (int i = args.length - 1; i >= 0; i--) {
            if (ObjectUtils.isEmpty(args[i])){
                log.error(joinPoint.getSignature().getDeclaringTypeName()+"值为null");
                throw new NullPointerException("传入的值为null");
            }else if(args.length-1==i){
                if (args[i] instanceof String){
                    byte[] bytes = ((String) args[i]).getBytes();
                    if (Base64.isBase64(bytes)){
                        args[i]=Base64.decode(bytes);
                    }
                }
            }
        }

    }
}
