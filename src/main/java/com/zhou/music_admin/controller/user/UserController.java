package com.zhou.music_admin.controller.user;

import com.zhou.music_admin.abnormal.ExceiptonUpdate;
import com.zhou.music_admin.abnormal.ExceptionInser;
import com.zhou.music_admin.dynamic_condition.Path;
import com.zhou.music_admin.entity.userBean.User;
import com.zhou.music_admin.service.user.UserControl;
import com.zhou.music_admin.service.user.imp.UserControlImp;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
            import org.apache.commons.lang3.StringUtils;
            import org.springframework.beans.factory.annotation.Autowired;

            import org.springframework.http.MediaType;
            import org.springframework.validation.annotation.Validated;
            import org.springframework.web.bind.annotation.*;
            import org.springframework.web.multipart.MultipartFile;

            import javax.servlet.http.HttpSession;
            import javax.validation.constraints.NotNull;
            import java.util.HashMap;
            import java.util.List;
            import java.util.Map;

            @RestController
            @Slf4j
    @RequiredArgsConstructor(onConstructor = @__(@Autowired))
            @Validated
    @RequestMapping(value = "/api/user/",produces = MediaType.APPLICATION_JSON_VALUE)
            public class UserController {
            private final UserControlImp userControl;


            @RequestMapping("select/count")
            public Integer getUserCount(HttpSession session,@RequestParam("like")String like){
        if(StringUtils.isEmpty(like)){
            return  userControl.getCount(like);
        }
       return(int) session.getAttribute("user_count");
    }
    @RequestMapping(value = "select/all/{index}",method = RequestMethod.GET)
    public List<User> getAllUser(@NotNull @PathVariable("index")Integer index){
        List<User> user = userControl.getUser(index);
        return  user;
    }
    @RequestMapping(value = "select/to/{username}",method = RequestMethod.GET)
    public User getOneUser(HttpSession session, @PathVariable("username")String username){
        User selUser = userControl.getSelUser(username);
        //记录信息
        session.setAttribute("user_to",selUser);
        return  selUser;
    }
    @RequestMapping(value = "select/like/{link}/{index}",method = RequestMethod.GET)
    public List<User> adminLinkUser(@PathVariable("link")String link,@PathVariable Integer index){
        List<User> user = userControl.getSelLinkUser(link,index);
        return  user;
    }
    @GetMapping("update")
    public String updateUser(MultipartFile img, HttpSession ses, User user, String username) throws ExceiptonUpdate {
        @NotNull(message = "传入的值不能为空")
        User user_to = (User) ses.getAttribute("user_to");
        //传递数据
        user.setFileImg(user_to.getFileImg());
        int i = userControl.upDateUser(user_to,user, username);
        if (i<1){
            return "-1";
        }
        return "1";
    }
    @PostMapping("insert")
    public String insertUser(User user) throws ExceptionInser {
        int i = userControl.insertUser(user);
            if (i<1){
                return "-1";
            }
        return "1";
    }
    @PostMapping("delete/{username}")
    public String delteUser(@PathVariable String username){
        int i = userControl.deleteUser(username);
        if (i>0){
            return "1";
        }
        return "-1";
    }
}
