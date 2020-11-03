package com.zhou.music_admin.controller.user;

import com.zhou.music_admin.entity.userMusicBean.UserMusic;
import com.zhou.music_admin.service.user.imp.AffairsUserMusicImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/user/music")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserMusicController {
    private final AffairsUserMusicImp affairsUserMusicImp;
    @RequestMapping("/select/all")
    public List<UserMusic> getAllUserMusic(@RequestParam String username){
        List<UserMusic> selUserMusic = affairsUserMusicImp.getSelUserMusic(username);
        return selUserMusic;
    }

    @RequestMapping("/delete/{music_id}")
    public String deleteUserMusic(@PathVariable String music_id){
        int i = affairsUserMusicImp.deleteUserMusic(music_id);
        if (i>0){
            return "1";
        }
        return "-1";
    }
}
