package com.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: Demo
 * @Date: 2019/2/25 16:04
 * @Author: LiJc
 * @Description:
 */
@Controller
@RequestMapping("test")
public class UploadController {

    @RequestMapping("upload")
    public String upload(){
        System.out.println("upload");
        return "views/upload";
    }

    public String upload1(){
        System.out.println("upload1");
        return "views/upload";
    }
}
