package com.marno.btm.entity;

import java.util.Date;
/**
 * table name:  scene
 * author name: Marno
 * create time: 2020-02-11 23:53:16
 */ 
public class Scene{

	private String sceneID;
	private int originatorID;
	private String theme;
	private int mode;
	private int state;
	private Date creatTime;
	private String serviceID;

	public void setSceneID(String sceneID){
		this.sceneID=sceneID;
	}
	public String getSceneID(){
		return sceneID;
	}
	public void setOriginatorID(int originatorID){
		this.originatorID=originatorID;
	}
	public int getOriginatorID(){
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
	public void setState(int state){
		this.state=state;
	}
	public int getState(){
		return state;
	}
	public void setCreatTime(Date creatTime){
		this.creatTime=creatTime;
	}
	public Date getCreatTime(){
		return creatTime;
	}
	public void setServiceID(String serviceID){
		this.serviceID=serviceID;
	}
	public String getServiceID(){
		return serviceID;
	}

	@Override
	public String toString() {
		return "scene{" + 
			"sceneID=" + sceneID + 
			", originatorID=" + originatorID + 
			", theme=" + theme + 
			", mode=" + mode + 
			", state=" + state + 
			", creatTime=" + creatTime + 
			", serviceID=" + serviceID + 
			"}";
	}
}

