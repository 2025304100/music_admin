package com.zhou.music_admin.security_module;

import com.zhou.music_admin.dao.UrlFilterBean.UrlfilterMapper;
import com.zhou.music_admin.entity.UrlFilterBean.UrlAuthorizationBean;
import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


@Slf4j
@Service
public class ShiroFileChainManager {

    @Resource
    UrlfilterMapper urlfilterMapper;
    public Map<String, String> loadFilterChainDefinitionMap(String key){
        Map<String, String> filterChainDefinitionMap = new HashMap<>();

        List<UrlAuthorizationBean> authorization=null;
        if (key!=null) {
            authorization = urlfilterMapper.getAuthorization(key);
        }else {
            //为认证访问
            authorization=urlfilterMapper.getUrlTitle();
        }
            authorization.forEach(e->{
                StringJoiner stringJoiner = new StringJoiner(",", "roles[", "]");
                stringJoiner.add(e.getRoles()==null?"root":e.getRoles());
                filterChainDefinitionMap.put(e.getUrl(),stringJoiner.toString());
                System.out.println(e.getUrl()+stringJoiner.toString());
            });
        filterChainDefinitionMap.put("/index/toLogin","anon");
            log.info("--------------- 访问 ---------------"+filterChainDefinitionMap.size());




        return filterChainDefinitionMap;

    }
    public void upDataFilterChainManager(String key, ShiroFilterFactoryBean shiroFilterFactoryBean,Boolean isb) throws Exception {

        synchronized (this){
            AbstractShiroFilter shiroFilter;
            try {
               shiroFilter=(AbstractShiroFilter) shiroFilterFactoryBean.getObject();
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("错误");
            }
            PathMatchingFilterChainResolver filterChainResolver= (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
            DefaultFilterChainManager    Manager= (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

            // 清空拦截管理器中的存储
            Manager.getFilterChains().clear();
            // 清空拦截工厂中的存储,如果不清空这里,还会把之前的带进去
            //            ps:如果仅仅是更新的话,可以根据这里的 map 遍历数据修改,重新整理好权限再一起添加
            shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
            // 动态查询数据库中所有权限
            shiroFilterFactoryBean.setFilterChainDefinitionMap(loadFilterChainDefinitionMap(key));
            // 重新构建生成拦截
            Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                log.info("entry.getKey()={};entry.getValue()={}",entry.getKey(),entry.getValue());
                Manager.createChain(entry.getKey(), entry.getValue());
            }
            if(key!= null){
                updatePermissionByRoleId(key,isb);
            }
        }
    }
    public void updatePermissionByRoleId(String roleId, Boolean isRemoveSession) {
//        // 查询当前角色的用户shiro缓存信息 -> 实现动态权限
//        List<User> userList = userMapper.selectUserByRoleId(roleId);
//        // 删除当前角色关联的用户缓存信息,用户再次访问接口时会重新授权 ; isRemoveSession为true时删除Session -> 即强制用户退出
//        if ( !CollectionUtils.isEmpty( userList ) ) {
//            for (User user : userList) {
//                ShiroUtils.deleteCache(user.getUsername(), isRemoveSession);
//            }
//        }
//        log.info("--------------- 动态修改用户权限成功！ ---------------");
    }


}

