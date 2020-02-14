package com.marno.btm.service.impl;

import com.marno.btm.entity.Scene;
import com.marno.btm.service.MakeSceneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
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
    public String MakeScene(int originatorID, int mode, String serviceID,String theme) {
        String motto;
        if(createTwice(serviceID)==null){
            Scene scene = new Scene();
            scene.setSceneID(makeSceneID());
            scene.setCreatTime(new Date());
            scene.setMode(mode);
            scene.setOriginatorID(originatorID);
            scene.setState(1);//默认创建即可用
            scene.setServiceID(serviceID);
            scene.setTheme(theme);
            System.out.println("正在创建新的场景事件...");
            makeSceneMapper.makeScene(scene);
            System.out.println("场景事件已创建，正在创建新的签到表...");
            String sceneTableName = "scene_"+scene.getSceneID();
            makeSceneMapper.makeSceneTable(sceneTableName);
            System.out.println("新的表已经建好");
            motto = "创建成功，签到设备ID为："+scene.getServiceID();
        }else if(createTwice(serviceID)==originatorID){
            motto="这个信标已经被你用过啦，先停止它的任务吧！";
        }else {
            motto="这个信标已经被别人用啦，换个信标试试吧！";
        }
        return motto;
    }

    /**
     * 以当前时间生成场景ID
     * @return
     */
    private String makeSceneID(){
        Calendar c = Calendar.getInstance();
        String year=Integer.toString(c.get(Calendar.YEAR));
        String month=Integer.toString(c.get(Calendar.MONTH)+1);
        String day=Integer.toString(c.get(Calendar.DAY_OF_MONTH));
        String hh=Integer.toString(c.get(Calendar.HOUR_OF_DAY));
        String mi=Integer.toString(c.get(Calendar.MINUTE));
        String ss = Integer.toString(c.get(Calendar.SECOND));
        System.out.println("新的场景ID："+year+month+day+hh+mi+ss);
        return year+month+day+hh+mi+ss;
    }

    /**
     * 查询是否有重复创建任务
     */
    Integer createTwice(String serviceID){
        return makeSceneMapper.createTwice(serviceID);
    }
}
