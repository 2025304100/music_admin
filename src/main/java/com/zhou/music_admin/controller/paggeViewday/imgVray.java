package com.zhou.music_admin.controller.paggeViewday;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping(value = "/vray",consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
@Slf4j
public class imgVray {
    @GetMapping("/music/img/{id}")
    public String vrayImg(
            @PathVariable String id,
            HttpSession session
            ){


        return "ok";
    }
}
