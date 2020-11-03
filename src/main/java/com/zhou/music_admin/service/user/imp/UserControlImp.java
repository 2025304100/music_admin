package com.zhou.music_admin.service.user.imp;

import com.zhou.music_admin.entity.userBean.User;
import com.zhou.music_admin.entity.userIdentityBean.UserIdentity;
import com.zhou.music_admin.service.ServletMapper;
import com.zhou.music_admin.service.user.AdditionUser;
import com.zhou.music_admin.service.user.UserControl;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class  UserControlImp extends ServletMapper implements UserControl, AdditionUser {
    @Override
    public List<User> getUser(Integer index) {
        List<User> users = userMapper.getAllUser((index-1)*20,index*20);
        //判断是否为空
        if (ObjectUtils.isEmpty(users)) {
            users = new ArrayList<>();
        }
        return users;
    }

    @Override
    public List<User> getSelLinkUser(String like,Integer index) {
        List<User> selLikeUser = userMapper.getSelLikeUser(like,(index-1)*20,index*20);
        return selLikeUser;
    }

    @Override
    public User getSelUser(String key) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username",key);
        User user = userMapper.selectOneByExample(example);
        return user;
    }

    @Override
    public int upDateUser(User oldUser,User user,String username) {
        if (oldUser.toString().equals(user.toString())){
            return 1;
        }
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username",username);
        int i = userMapper.updateByExampleSelective(user, example);
        return i;
    }

    @Override
    public int deleteUser(String key) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username",key);
        int i = userMapper.deleteByExample(example);
        return i;
    }
        private  int i;
    @Override
    public int deleteAllUser(List<String> keys) { ;
        keys.forEach(e->{
            Example example = new Example(User.class);
            example.createCriteria().andEqualTo("username",e);
           this.i= userMapper.deleteByExample(example);
        });
        return this.i;
    }

    @Override
    public int insertUser(User user) {
        if(ObjectUtils.isEmpty(user)) {
            return -2;
        }
        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public int insertAllUser(List<User> userList) {


        return 0;
    }

    @Override
    public int getUserCount(String like) {
        Long count = userMapper.getCount(like);
        if (ObjectUtils.isEmpty(count)) {
            count = 0L;
        }
        int maxIndex = (int) (count / 20);
        return count % 20 == 0 ? maxIndex : maxIndex + 1;
    }

    @Override
    public int getCount(String like) {
        Long count = userIdentityMapper.getCount(like);
        //防空检测
        if(ObjectUtils.isEmpty(count)){
            count=0L;
        }
        int maxIndex= (int) (count/20);
        return count%20==0?maxIndex:maxIndex+1;
    }

    @Override
    public UserIdentity getOneIdentity(String username) {
        Example example = new Example(UserIdentity.class);
        example.createCriteria().andEqualTo("username",username);
        UserIdentity userIdentity = userIdentityMapper.selectOneByExample(example);
        return userIdentity;
    }

    @Override
    public List<UserIdentity> getAllIdentity(int index) {
        List<UserIdentity> userIdentities =
                userIdentityMapper.getAllIdentity((index-1)*20,index*20);
        return userIdentities;
    }

    @Override
    public List<UserIdentity> getLikeIdentity(String like,Integer index) {
        List<UserIdentity> likeIdentity = userIdentityMapper.getLikeIdentity(like,(index-1)*20,index*20);
        return likeIdentity;
    }

    @Override
    public int deleteIdentity(String username) {
        Example example = new Example(UserIdentity.class);
        example.createCriteria().andEqualTo("username",username);
        int i = userMapper.deleteByExample(example);
        return i;
    }

    @Override
    public int insertIdentity(UserIdentity userIdentity) {
        int insert = userIdentityMapper.insert(userIdentity);
        return insert;
    }

    @Override
    public int upDateUser(UserIdentity olduserIdentity,UserIdentity userIdentity,String username) {
        Example example = new Example(UserIdentity.class);
        if (olduserIdentity.equals(userIdentity)){
            return -1;
        }
        example.createCriteria().andEqualTo("username",userIdentity);
        int i = userIdentityMapper.updateByExample(userIdentity, example);
        return i;
    }
}
