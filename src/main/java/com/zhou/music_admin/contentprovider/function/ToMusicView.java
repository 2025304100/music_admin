package com.zhou.music_admin.contentprovider.function;

import com.zhou.music_admin.entity.musicBean.MusicView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ToMusicView {
 @Value("${music.hostPath}")
    public MusicView toView(MusicView musicView){
        MusicView view = new MusicView();
        return view;
    }

}
