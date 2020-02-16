package com.marno.btm.entity;

import java.util.Date;
/**
 * table name:  scene
 * author name: Marno
 * create time: 2020-02-16 22:55:01
 */ 
public class Scene{

	private String sceneID;
	private String originatorID;
	private String theme;
	private String hoster;
	private Date creatTime;
	private Date startTime;
	private Date endTime;
	private String address;
	private int ifRegister;
	private String message;
	private int mode;
	private String deviceID;

	public void setSceneID(String sceneID){
		this.sceneID=sceneID;
	}
	public String getSceneID(){
		return sceneID;
	}
	public void setOriginatorID(String originatorID){
		this.originatorID=originatorID;
	}
	public String getOriginatorID(){
		return originatorID;
	}
	public void setTheme(String theme){
		this.theme=theme;
	}
	public String getTheme(){
		return theme;
	}
	public void setHoster(String hoster){
		this.hoster=hoster;
	}
	public String getHoster(){
		return hoster;
	}
	public void setCreatTime(Date creatTime){
		this.creatTime=creatTime;
	}
	public Date getCreatTime(){
		return creatTime;
	}
	public void setStartTime(Date startTime){
		this.startTime=startTime;
	}
	public Date getStartTime(){
		return startTime;
	}
	public void setEndTime(Date endTime){
		this.endTime=endTime;
	}
	public Date getEndTime(){
		return endTime;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public void setIfRegister(int ifRegister){
		this.ifRegister=ifRegister;
	}
	public int getIfRegister(){
		return ifRegister;
	}
	public void setMessage(String message){
		this.message=message;
	}
	public String getMessage(){
		return message;
	}
	public void setMode(int mode){
		this.mode=mode;
	}
	public int getMode(){
		return mode;
	}
	public void setDeviceID(String deviceID){
		this.deviceID=deviceID;
	}
	public String getDeviceID(){
		return deviceID;
	}

	@Override
	public String toString() {
		return "scene{" + 
			"sceneID=" + sceneID + 
			", originatorID=" + originatorID + 
			", theme=" + theme + 
			", hoster=" + hoster + 
			", creatTime=" + creatTime + 
			", startTime=" + startTime + 
			", endTime=" + endTime + 
			", address=" + address + 
			", ifRegister=" + ifRegister + 
			", message=" + message + 
			", mode=" + mode + 
			", deviceID=" + deviceID + 
			"}";
	}
}

