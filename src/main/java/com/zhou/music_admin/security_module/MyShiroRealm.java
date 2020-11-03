package com.zhou.music_admin.security_module;

import com.zhou.music_admin.entity.adminUserBean.AdminRoleUser;
import com.zhou.music_admin.service.AdminUserService;
;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;

import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;


@Slf4j
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    AdminUserService adminUserService;


    //权限认证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        log.info("身份认证");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        //获取身份的信息
      String role= (String) principals.getPrimaryPrincipal();
      //注入身份
        System.out.println(role);
        authorizationInfo.addRole(role);
        Set<String> roles=new HashSet<>();
        roles.add(role);
        authorizationInfo.setRoles(roles);
        return authorizationInfo;
    }

    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String d_pas = null;
        System.out.println("认证");
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;//获取用户信息
        String user_ = token1.getUsername(), password = String.valueOf(token1.getPassword());
        AdminRoleUser admusicUserView = adminUserService.getAdmusicUserView(user_);
        if (ObjectUtils.isEmpty(admusicUserView)) {
            throw new AuthenticationException("用户密码异常");
        }
        log.info("用户username={}", admusicUserView.toString());
        //刷新权限

        if (password.equals(admusicUserView.getPassword())) {
            log.info(admusicUserView.getRoleType());
            //分配角色

            SimpleAuthenticationInfo ordinary = new SimpleAuthenticationInfo(admusicUserView.getRoleType(),token1.getPassword(),getName());
            return ordinary;
        } else {
            throw new AuthenticationException("用户密码异常");
        }


    }
}

