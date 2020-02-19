package com.marno.btm.entity;

/**
 * table name:  users
 * author name: Marno
 * create time: 2020-02-19 04:07:27
 */ 
public class Users{

	private String userID;
	private String userName;
	private String nickName;
	private String avatarUrl;
	private String gender;
	private String unionId;
	private String city;
	private String province;
	private String country;

	public void setUserID(String userID){
		this.userID=userID;
	}
	public String getUserID(){
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
	public void setUnionId(String unionId){
		this.unionId=unionId;
	}
	public String getUnionId(){
		return unionId;
	}
	public void setCity(String city){
		this.city=city;
	}
	public String getCity(){
		return city;
	}
	public void setProvince(String province){
		this.province=province;
	}
	public String getProvince(){
		return province;
	}
	public void setCountry(String country){
		this.country=country;
	}
	public String getCountry(){
		return country;
	}

	@Override
	public String toString() {
		return "users{" + 
			"userID=" + userID + 
			", userName=" + userName + 
			", nickName=" + nickName + 
			", avatarUrl=" + avatarUrl + 
			", gender=" + gender + 
			", unionId=" + unionId + 
			", city=" + city + 
			", province=" + province + 
			", country=" + country + 
			"}";
	}
}

