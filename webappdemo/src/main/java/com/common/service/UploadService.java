package com.common.service;

import com.common.form.FileForm;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: Demo
 * @Date: 2019/2/22 12:24
 * @Author: LiJc
 * @Description:
 *      springMvc配置的MultipartResolver处理器已经对文件做了解析（List<FileItem> items = upload.parseRequest(request);）
 *      如需要使用MultipartResolver配置，可使用MultipartFile file[]接收
 */
@Service
public class UploadService {
    /** 上传文件根路径 */
    private String uploadRootPath;

    /** 上传文件子路径 */
    private String subPath = "";

    /** 上传文件是否重命名 */
    private boolean isRename = true;

    public String getUploadRootPath() {
        if(StringUtils.isEmpty(this.uploadRootPath)){
            this.uploadRootPath = "D:\\upload";
        }
        return uploadRootPath;
    }

    public void setUploadRootPath(String uploadRootPath) {
        this.uploadRootPath = uploadRootPath;
    }

    public String getSubPath() {
        return subPath;
    }

    public void setSubPath(String subPath) {
        this.subPath = subPath;
    }

    public boolean isRename() {
        return isRename;
    }

    public void setRename(boolean isRename) {
        this.isRename = isRename;
    }

    /**
     * 上传文件
     * @param request
     * @return
     * @throws Exception
     */
    public List<FileForm> uploadFiles(HttpServletRequest request) throws Exception {

        List<FileForm> list = new ArrayList<FileForm>();

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        List<FileItem> items = upload.parseRequest(request);
        Iterator<FileItem> itr = items.iterator();
        int i = 0;
        while (itr.hasNext()) {
            FileItem item = (FileItem) itr.next();
            if (!item.isFormField() && item.getName() != null && !item.getName().equals("")) {
                // 上传文件
                FileForm fileForm = this.uploadFile(item);
                fileForm.setFileId(UUID.randomUUID().toString());
                list.add(fileForm);
                i++;

                // TODO 写入数据库
            }
        }

        return list;
    }

    /**
     * 上传文件
     * @param item
     * @return
     * @throws Exception
     */
    public FileForm uploadFile(FileItem item) throws Exception {
        // item.getName()返回上传文件在客户端的完整路径名称
        File tempFile = new File(item.getName());
        String fileName = tempFile.getName();// 原始文件名
        String filePath = this.getSavePath(this.subPath, fileName, this.isRename);

        // 上传文件
        File file = new File(this.getUploadRootPath() + filePath);
        FileUtils.forceMkdir(file.getParentFile());
        item.write(file);

        FileForm fileForm = new FileForm();
        fileForm.setName(fileName);
        fileForm.setFilePath(filePath);// 存放路径
        fileForm.setContentType(item.getContentType());// 数据格式
        fileForm.setSize(item.getSize());// 文件大小
        fileForm.setFileUrl(filePath);

        return fileForm;
    }

    /**
     * 构建文件路径
     * @param subPath
     * @param fileName
     * @param isRename
     * @return
     */
    public String getSavePath(String subPath, String fileName, boolean isRename) {
        // 处理子路径
        if (!StringUtils.isBlank(subPath)) {
            subPath += "\\";
        } else {
            subPath = "";
        }
        // 处理日期路径
        Date date = new Date();
        SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
        SimpleDateFormat mm = new SimpleDateFormat("MM");
        String datePath = MessageFormat.format("{0}\\{1}\\", yyyy.format(date), mm.format(date));
        if(isRename){
            int dotIndex = fileName.lastIndexOf(".");
            String ext = fileName.substring(dotIndex, fileName.length());
            fileName = UUID.randomUUID().toString() + ext;
        }
        return "\\" + subPath + datePath + fileName;
    }
}
