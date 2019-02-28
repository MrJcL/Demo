package com.common.form;

/**
 * @program: 文件上传表单类
 * @Date: 2019/2/27 21:26
 * @Author: LiJc
 * @Description:
 */
public class FileForm {

	private String fileId;
	private String name;
	private String filePath;
	private String contentType;
	private Long size;
	private String fileUrl;
	
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String filePath) {
		this.fileUrl = filePath;
	}
}
