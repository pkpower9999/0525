package kr.co.uk.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


public class BoardVO {
	
	private int seq;
	private String title;
	private String content;
	private String registuser;
	private Date registdate;
	private String updateuser;
	private Date updatedate;
	private String status;
	private String files_seq;
	private String password;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegistuser() {
		return registuser;
	}
	public void setRegistuser(String registuser) {
		this.registuser = registuser;
	}
	public Date getRegistdate() {
		return registdate;
	}
	public void setRegistdate(Date registdate) {
		this.registdate = registdate;
	}
	public String getUpdateuser() {
		return updateuser;
	}
	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFiles_seq() {
		return files_seq;
	}
	public void setFiles_seq(String files_seq) {
		this.files_seq = files_seq;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
