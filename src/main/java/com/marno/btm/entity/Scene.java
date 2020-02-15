package com.marno.btm.entity;

import java.util.Date;
/**
 * table name:  scene
 * author name: Marno
 * create time: 2020-02-16 02:54:05
 */ 
public class Scene{

	private String sceneID;
	private String originatorID;
	private String theme;
	private int mode;
	private Date creatTime;
	private String deviceID;
	private String message;
	private Date startTime;
	private Date endTime;
	private int ifRegister;

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
	public void setMode(int mode){
		this.mode=mode;
	}
	public int getMode(){
		return mode;
	}
	public void setCreatTime(Date creatTime){
		this.creatTime=creatTime;
	}
	public Date getCreatTime(){
		return creatTime;
	}
	public void setDeviceID(String deviceID){
		this.deviceID=deviceID;
	}
	public String getDeviceID(){
		return deviceID;
	}
	public void setMessage(String message){
		this.message=message;
	}
	public String getMessage(){
		return message;
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
	public void setIfRegister(int ifRegister){
		this.ifRegister=ifRegister;
	}
	public int getIfRegister(){
		return ifRegister;
	}

	@Override
	public String toString() {
		return "scene{" + 
			"sceneID=" + sceneID + 
			", originatorID=" + originatorID + 
			", theme=" + theme + 
			", mode=" + mode + 
			", creatTime=" + creatTime + 
			", deviceID=" + deviceID + 
			", message=" + message + 
			", startTime=" + startTime + 
			", endTime=" + endTime + 
			", ifRegister=" + ifRegister + 
			"}";
	}
}

