package com.marno.btm.service.impl;

import com.marno.btm.entity.Scene;
import com.marno.btm.service.MakeSceneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 叶勇
 * @version 1.0
 * @date 2020/2/10 22:49
 */
@Service
public class MakeSceneServiceIpml implements MakeSceneService {

    @Resource
    private com.marno.btm.mapper.makeSceneMapper makeSceneMapper;

    @Override
    public String MakeScene(int originatorID, int mode, String serviceID,String theme) {
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
        makeSceneMapper.makeSceneTable(scene.getSceneID());
        System.out.println("新的表已经建好");
        return "创建成功，签到设备ID为："+scene.getServiceID();
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
        System.out.println("新的场景ID："+year+month+day+hh+mi);
        return year+month+day+hh+mi;
    }
}
