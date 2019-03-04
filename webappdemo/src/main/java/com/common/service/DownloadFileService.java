package com.common.service;

import com.common.form.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @program: Demo
 * @Date: 2019/3/4 21:42
 * @Author: LiJc
 * @Description:
 */
@Service
public class DownloadFileService {

    private String uploadfolder;

    public String getUploadfolder() {
        if(StringUtils.isEmpty(uploadfolder)){
            uploadfolder = "D:\\upload";
        }
        return uploadfolder;
    }

    public void setUploadfolder(String uploadfolder) {
        this.uploadfolder = uploadfolder;
    }

    public Result download(String fileUrl, String fileName, HttpServletRequest request, HttpServletResponse response) {
        Result result = new Result();
        if(StringUtils.isEmpty(fileUrl)){
            result.setMessage("路径为空！");
            result.setSuccess(false);
        }
        String filePath =  getUploadfolder()  + "/" + fileUrl;
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            try {
                InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
                byte[] buffer = new byte[inputStream.available()]; // int
                // available()
                // 返回值为流中尚未读取的字节的数量
                inputStream.read(buffer);
                inputStream.close();

                response.reset();
                String header = request.getHeader("User-Agent").toUpperCase();
                if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {
                    fileName = URLEncoder.encode(fileName, "utf-8");
                } else {
                    fileName = new String(fileName.getBytes(), "ISO8859-1");
                }
                response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
                response.addHeader("Content-Length", "" + file.length());

                OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                outputStream.write(buffer);
                outputStream.flush();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
                result.setMessage("下载异常！");
                result.setSuccess(false);
            }
        } else {
            result.setMessage("文件不存在！");
            result.setSuccess(false);
        }
        return result;
    }

}
