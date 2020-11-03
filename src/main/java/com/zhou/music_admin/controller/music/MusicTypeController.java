package com.zhou.music_admin.controller.music;


import com.zhou.music_admin.entity.mtypeBean.Mtype;
import com.zhou.music_admin.service.music.imp.MusicTypeImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/api/music/type",produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MusicTypeController {
    private final MusicTypeImp musicTypeImp;
    @RequestMapping("/select/all")
    public List<Mtype> getAllType(){
        List<Mtype> allMtype = musicTypeImp.getAllMtype();
        return allMtype;
    }
    @RequestMapping("/select/to/{id}")
    public Mtype getOneType(HttpSession session, @PathVariable Integer id){
        Mtype oneMtype = musicTypeImp.getOneMtype(id);
        session.setAttribute("music_type_to",oneMtype);
        return oneMtype;
    }
    @RequestMapping("/insert/to")
    public String insertMusicType( Mtype music){
        log.info("日志:{}",music.toString());
        Integer integer = musicTypeImp.insertMtype(music);
        if (integer>0){
            return "1";
        }
        return "-1";
    }
    @RequestMapping("/delete/to/{id}")
    public String deleteMusicType(@PathVariable  Integer id){

        Integer integer = musicTypeImp.deteleMtype(id);
        if (integer>0){
            return "1";
        }
        return "-1";
    }
    @RequestMapping("update/to")
    public String updateMusicType(HttpSession session,Mtype type){
        Mtype old_mtype= (Mtype) session.getAttribute("music_type_to");
        type.setId(old_mtype.getId());
        Integer integer = musicTypeImp.updateMtype(old_mtype, type);
        if (integer>0){
            return "1";
        }
        return "-1";
    }
}
