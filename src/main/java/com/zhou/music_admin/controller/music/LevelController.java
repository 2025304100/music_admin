package com.zhou.music_admin.controller.music;

import com.zhou.music_admin.entity.lyircBean.Lyirc;
import com.zhou.music_admin.service.music.imp.MusicLevelImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/music/rank")
@Validated
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LevelController  {
    private final MusicLevelImp musicLevelImp;

    /**
     * 打印所有音乐级别
     * @return
     */
    @RequestMapping("/select/all")
    public List<Lyirc> getAllMusicLevel(){
        List<Lyirc> allMusicLevel = musicLevelImp.getAllMusicLevel();
        return allMusicLevel;
    }

    /**
     * 查询音乐级别
     * @param id
     * @return
     */
    @RequestMapping("/select/to/{id}")
    public Lyirc getOneMusicLevel(HttpSession session, @PathVariable Integer id){
        Lyirc oneMusicLevel = musicLevelImp.getOneMusicLevel(id);
        session.setAttribute("rank_to",oneMusicLevel);
        return oneMusicLevel;
    }

    /**
     * 添加音乐级别
     * @param lyirc
     * @return
     */
    @RequestMapping("/insert")
    public String inserMusicLevel(@Validated Lyirc lyirc){
        Integer integer = musicLevelImp.insertMusicLevel(lyirc);
        if (integer>0){
            return "1";
        }
        return "-1";
    }

    /**
     * 删除音乐级别
     * @param id
     * @return
     */
    @RequestMapping("/delete/to/{id}")
    public String deleteMusicLevel(@PathVariable Integer id){
        Integer integer = musicLevelImp.deleteMusicLevel(id);
        if (integer>0){
            return "1";
        }
        return "-1";
    }
    @RequestMapping("/update/to")
    public String updateMusicLevel(HttpSession session,@Validated Lyirc lyirc){
        Lyirc lyirc1= (Lyirc) session.getAttribute("rank_to");
        //赋值id
        lyirc.setId(lyirc1.getId());
        Integer integer = musicLevelImp.updateMusicLevel(lyirc1, lyirc);
        if (integer>0){
            return "1";
        }
        return "-1";
    }

}
