package com.zhou.music_admin.service.user;


import com.zhou.music_admin.entity.userIdentityBean.UserIdentity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdditionUser {
    int getCount(String like);

    UserIdentity getOneIdentity(String username);

    List<UserIdentity> getAllIdentity(int index);

    List<UserIdentity> getLikeIdentity(String link,Integer index);

    int deleteIdentity(String username);

    int insertIdentity(UserIdentity userIdentity);


    int upDateUser(UserIdentity oldUserIdentity,UserIdentity userIdentity,String username);

}
