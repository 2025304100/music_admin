package com.zhou.music_admin.security_module;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiorConfig {
    /**
     * 认证
     * @return
     */

    @Resource


    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(
            ShiroFileChainManager shiroFileChainManager,
            DefaultWebSecurityManager defaultWebSecurityManager,
            StatelessAuthcFilter statelessAuthcFilter
            ){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setFilterChainDefinitionMap(shiroFileChainManager.loadFilterChainDefinitionMap(null));
        bean.setSecurityManager(defaultWebSecurityManager);
        Map<String, Filter> filters = new LinkedHashMap<>();
        //添加拦截配置
        filters.put("user",statelessAuthcFilter);
        bean.setFilters(filters);
        System.out.println("demo-----app-------");
        bean.setLoginUrl("/index/login");

        return bean;
    }

    @Bean
    DefaultWebSecurityManager defaultWebSecurityManager() {

        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();

        manager.setRealm(mySiroRealm());

        return manager;
    }
    @Bean
    public MyShiroRealm mySiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }

    /**
     * 自定义设置安全
     * @return
     */
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
//        // 散列算法:这里使用SHA256算法;
//        shaCredentialsMatcher.setHashAlgorithmName(SHA256Util.HASH_ALGORITHM_NAME);
//        // 散列的次数，比如散列两次，相当于 md5(md5(""));
//        shaCredentialsMatcher.setHashIterations(SHA256Util.HASH_ITERATIONS);
//        return shaCredentialsMatcher;
//    }
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    //开启shiro aop注解支持.
    @Bean("authorizationAttributeSourceAdvisor")
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager());
        return authorizationAttributeSourceAdvisor;
    }


}
