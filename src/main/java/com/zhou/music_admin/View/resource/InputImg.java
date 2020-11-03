package com.zhou.music_admin.View.resource;

import lombok.Builder;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.*;

@Service

public class InputImg {
    @Value("${music.file.home}")
    private String home;
    @Value("${music.file.path.user_img}")
    private String user_img;
    @Value("${music.file.path.music}")
    private String music;
    @Value("${music.file.path.music_img}")
    private String music_img;


    public Imp getImg(String username, String file_Path) throws IOException {
        String subbix=file_Path.substring(file_Path.indexOf('.')+1);
        File file = new File(home + user_img + username, file_Path);

        InputStream In = null;
            try {
                if (!file.isDirectory()) {
                    throw new IOException("内容为空");
                }
                In=new FileInputStream(file);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {

                In.close();
            }
        Imp imp = new Imp();
            imp.setSubbx(subbix);
            imp.setInputStream(In);
        return imp;
    }
    @Data
   public class Imp{
        private String subbx;
        private InputStream inputStream;

    }
}
