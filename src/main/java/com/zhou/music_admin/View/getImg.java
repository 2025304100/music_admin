package com.zhou.music_admin.View;

import com.zhou.music_admin.View.resource.InputImg;
import io.netty.handler.ipfilter.UniqueIpFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/api/img")
public class getImg {

    @RequestMapping(value = "/user/{path}")
    public void viewImg(InputImg img,
                          @RequestParam String username,
                          @PathVariable("path") String path,
                          HttpServletResponse rep) throws IOException {
        InputImg.Imp img1 = img.getImg(username, path);
        InputStream inputStream = img1.getInputStream();
        String subbx = img1.getSubbx();
        ServletOutputStream outputStream = rep.getOutputStream();
        int i;
        while ((i=inputStream.read())!=-1) {
            outputStream.write(i);
        }
        outputStream.close();
        rep.setHeader("content-type",": image/"+subbx);
    }


}
