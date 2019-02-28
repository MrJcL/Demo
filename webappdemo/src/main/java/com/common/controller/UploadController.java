package com.common.controller;

import com.common.form.FileForm;
import com.common.service.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: Demo
 * @Date: 2019/2/25 16:04
 * @Author: LiJc
 * @Description:
 */
@Controller
@RequestMapping("upload")
public class UploadController {

    @Inject
    private UploadService uploadService;

    @PostMapping("exec")
    @ResponseBody
    public String exec(HttpServletRequest request){
        System.out.println("exec");
        try{
            List<FileForm> fileForms = this.uploadService.uploadFiles(request);
            System.out.println(fileForms.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }

    @GetMapping
    public String upload(){
        System.out.println("upload");
        return "views/upload";
    }

    @GetMapping("a")
    @ResponseBody
    public String a(){
        return "aaa";
    }
}
