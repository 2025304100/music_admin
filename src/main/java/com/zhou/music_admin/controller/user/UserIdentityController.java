package com.zhou.music_admin.controller.user;

import com.zhou.music_admin.dao.userIdentityBean.UserIdentityMapper;
import com.zhou.music_admin.entity.userBean.User;
import com.zhou.music_admin.entity.userIdentityBean.UserIdentity;
import com.zhou.music_admin.service.user.AdditionUser;
import com.zhou.music_admin.service.user.UserControl;
import com.zhou.music_admin.service.user.imp.UserControlImp;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Validated
@RequestMapping(value = "/api/user/identity",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserIdentityController {
    private final UserControlImp userControlImp;
    @RequestMapping("select/identity/count")
    public Integer getIdentityCount(HttpSession session,@RequestParam("like") String like){
        if(StringUtils.isEmpty(like)){
            return  userControlImp.getCount(like);
        }
        return (Integer) session.getAttribute("identity_count");
    }
    @RequestMapping("/select/all/{index}")
    public List<UserIdentity> getAllIdentity(Integer index){
        List<UserIdentity> allIdentity = userControlImp.getAllIdentity(index);
        return  allIdentity;
    }
    @RequestMapping("/select/like/{index}")
    public List<UserIdentity> getLikeIdentity(@NotNull @PathVariable("index") Integer index,@RequestParam("like") String identity){
        List<UserIdentity> likeIdentity = userControlImp.getLikeIdentity(identity,index);
        return likeIdentity;
    }
    @RequestMapping("/select/{username}")
    public UserIdentity getOneIdentity(HttpSession session,@NotNull@PathVariable String username){
        UserIdentity oneIdentity = userControlImp.getOneIdentity(username);
        session.setAttribute("identity_up",oneIdentity);
        return oneIdentity;
    }
    @RequestMapping("/delete/{username}")
    public String getDeleteIdentity(@NotNull @PathVariable String username){
        int i = userControlImp.deleteIdentity(username);
        if (i>0){
            return "1";
        }
        return "-1";
    }

    @RequestMapping("/update")
    public String getUpdateIdentity(HttpSession session, @NotNull UserIdentity userIdentity, @NotNull String username){
        @NotNull(message = "获取的数据为空")
        UserIdentity oldIdentity= (UserIdentity) session.getAttribute("identity_up");
        int i = userControlImp.upDateUser(oldIdentity,userIdentity, username);
        if (i>0){
            return "1";
        }
        return "-1";
    }
}
