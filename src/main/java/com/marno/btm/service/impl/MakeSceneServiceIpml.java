package com.marno.btm.service.impl;

import com.marno.btm.entity.Scene;
import com.marno.btm.service.MakeSceneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author □+
 * @version 1.0
 * @date 2020/2/10 22:49
 */
@Service
public class MakeSceneServiceIpml implements MakeSceneService {

    @Resource
    private com.marno.btm.mapper.makeSceneMapper makeSceneMapper;

    @Override
    public int MakeScene(Scene scene) {
        int motto;
        if(deviceUsed(scene.getDeviceID(),scene.getStartTime(),scene.getEndTime())==null){
            System.out.println("正在创建新的场景事件...");
            makeSceneMapper.makeScene(scene);
            System.out.println("场景事件已创建，正在创建新的签到表...");
            String sceneTableName = "scene_"+scene.getSceneID();
            makeSceneMapper.makeSceneTable(sceneTableName);
            System.out.println("新的表已经建好");
            System.out.println("创建成功，签到设备ID为："+scene.getDeviceID());
            motto = 1;
        }else if(deviceUsed(scene.getDeviceID(),scene.getStartTime(),scene.getEndTime())==scene.getOriginatorID()){
            System.out.println("这个信标已经被你用过啦，先停止它的任务吧！");
            motto=2;
        }else {
            System.out.println("这个信标已经被别人用啦，换个信标试试吧！");
            motto=3;
        }
        return motto;
    }


    /**
     * 查询是否有重复创建任务
     */
    String deviceUsed(String deviceID, Date strtime,Date endtime){
        return makeSceneMapper.deviceUsed(deviceID,strtime,endtime);
    }
}