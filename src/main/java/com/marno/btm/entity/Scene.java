package com.marno.btm.entity;

import java.util.Date;
/**
 * table name:  scene
 * author name: Marno
 * create time: 2020-02-10 04:42:41
 */ 
public class Scene{

	private int sceneID;
	private int originatorID;
	private String theme;
	private int mode;
	private int state;
	private Date creatTime;

	public void setSceneID(int sceneID){
		this.sceneID=sceneID;
	}
	public int getSceneID(){
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

	@Override
	public String toString() {
		return "scene{" + 
			"sceneID=" + sceneID + 
			", originatorID=" + originatorID + 
			", theme=" + theme + 
			", mode=" + mode + 
			", state=" + state + 
			", creatTime=" + creatTime + 
			"}";
	}
}

