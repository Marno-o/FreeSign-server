package com.marno.btm.entity;

import java.util.Date;
/**
 * table name:  users
 * author name: Marno
 * create time: 2020-02-11 01:26:08
 */ 
public class Users{

	private int userID;
	private String userName;
	private String nickName;
	private String avatarUrl;
	private String gender;
	private String unionid;

	public void setUserID(int userID){
		this.userID=userID;
	}
	public int getUserID(){
		return userID;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserName(){
		return userName;
	}
	public void setNickName(String nickName){
		this.nickName=nickName;
	}
	public String getNickName(){
		return nickName;
	}
	public void setAvatarUrl(String avatarUrl){
		this.avatarUrl=avatarUrl;
	}
	public String getAvatarUrl(){
		return avatarUrl;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	public String getGender(){
		return gender;
	}
	public void setUnionid(String unionid){
		this.unionid=unionid;
	}
	public String getUnionid(){
		return unionid;
	}

	@Override
	public String toString() {
		return "users{" + 
			"userID=" + userID + 
			", userName=" + userName + 
			", nickName=" + nickName + 
			", avatarUrl=" + avatarUrl + 
			", gender=" + gender + 
			", unionid=" + unionid + 
			"}";
	}
}

