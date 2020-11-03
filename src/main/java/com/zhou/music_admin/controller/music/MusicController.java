package com.zhou.music_admin.controller.music;

import com.zhou.music_admin.entity.musicBean.Music;
import com.zhou.music_admin.service.music.imp.musicControlImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/music",produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MusicController {
    private final musicControlImp musicControl;

    /**
     * 主页导列出信息
     * @param index
     * @return
     */
    @RequestMapping("/select/main/{index}")
    public List<Music> getMainMusic(
            @NotNull(message = "id内容不能为空")
            @Min(value = 1, message = "id必须为正整数")
            @PathVariable("index") Integer index){
        List<Music> indexMusic = musicControl.getIndexMusic(index);
        return indexMusic;
    }

    /**
     * 获取音乐信息
     * @param index
     * @return
     */
    @RequestMapping("/select/{index}")
    public Music getOneMusic(
            @NotNull
            @Min(value = 1,message = "id必须为正整数")
            @PathVariable("index")Integer index,
            HttpSession ses){
        Music oneIdMusic = musicControl.getOneIdMusic(index);
        ses.setAttribute("music_to",oneIdMusic);
        return oneIdMusic;
    }

    /**
     * 根据作者和歌名进行模糊查询
     * @param link
     * @param index
     * @return
     */
    @RequestMapping("select/link/{index}")
    public List<Music> getLinkMusic(
            @NotNull
            @RequestParam("link")String link,
            @NotNull
            @Min(value = 1,message = "id必须为正整数")
            @PathVariable("index")Integer index){
        List<Music> likeMusic = musicControl.getLikeMusic(index, link);
        return likeMusic;
    }
    /**
     * 导出数据
     * @return
     */
    @RequestMapping("/select")
    public List<Music> getAllMusic(){
        List<Music> allMusic = musicControl.getAllMusic();
        return allMusic;
    }

    /**
     * 音乐添加
     * @param music
     * @return
     */
    @RequestMapping("/insert/to")
    public String insertMusic(@Validated Music music){
        int i = musicControl.insertMusic(music);
        if (i>0){
            return "1";
        }
        return "-1";
    }

    /**
     * 音乐添加
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String deleteMusic(@PathVariable Integer id){
        int i = musicControl.deteleOneMusic(id);
        if (i>0){
            return "1";
        }
        return "-1";
    }

    /**
     * 音乐修改
     * @param music
     * @param session
     * @return
     */
    @RequestMapping("/update/to")
    public String updateMusic(@Validated Music music,HttpSession session){
        Music oldMusic= (Music) session.getAttribute("music_to");
        int i = musicControl.upDateAuthorMusic(oldMusic, music);
        if (i>0){
            return "1";
        }
        return "-1";
    }
}
