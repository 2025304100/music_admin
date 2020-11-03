package com.zhou.music_admin.service.user;

import com.zhou.music_admin.entity.userBean.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserControl {
     List<User> getUser(Integer index);
     List<User> getSelLinkUser(String like,Integer index);
     User getSelUser(String key);
     int upDateUser(User oldUser,User user,String username);
     int deleteUser(String key);

     int deleteAllUser(List<String> keys);

     int insertUser(User user);

     int insertAllUser(List<User> userList);

     int getUserCount(String like);


}
