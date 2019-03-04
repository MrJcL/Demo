package com.common.controller;

import com.common.form.Result;
import com.common.service.DownloadFileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: Demo
 * @Date: 2019/3/4 22:10
 * @Author: LiJc
 * @Description:
 */
@Controller
@RequestMapping("download")
public class DownloadFileController {

    @Inject
    private DownloadFileService downloadFileService;

    /**
     * 执行下载操作
     *
     * @param fileUrl 附件URL
     * @param fileUrl 附件名称
     * @return
     */
    @GetMapping("exec")
    @ResponseBody
    public Result exec(String fileUrl, String fileName, HttpServletRequest request, HttpServletResponse response){
        Result result = new Result();
        try {
            result = downloadFileService.download(fileUrl, fileName, request, response);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("下载失败！");
            result.setSuccess(false);
        }
        return result;
    }
}
