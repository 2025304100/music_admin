package com.zhou.music_admin.service.music;

import com.zhou.music_admin.entity.mtypeBean.Mtype;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MusicType {
     List<Mtype> getAllMtype();

     Mtype getOneMtype(Integer id);

     Integer updateMtype(Mtype oldType,Mtype mtype);

     Integer insertMtype(Mtype mtype);

     Integer deteleMtype(Integer key);




}
