package com.marno.btm.controller;

import com.marno.btm.entity.Scene;
import com.marno.btm.service.MakeSceneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 叶勇
 * @version 1.0
 * @date 2020/2/10 22:33
 */

@Controller
public class MakeSceneController {
    /**
     * 新建签到场景
     * 需要参数：签到方式、蓝牙信标ID、发起人ID
     */

    @Resource
    private MakeSceneService makeSceneService;

    @RequestMapping("/makescene")
    @ResponseBody
    public String makescene(String originatorID,
                            String theme,
                            int mode,
                            String deviceId,
                            String mymessage,
                            boolean ifRegister,
                            String stdate,
                            String sttime,
                            Integer timelong) throws ParseException {
        System.out.println("String originatorID," +originatorID+
                "                            \nString theme," +theme+
                "                            \nint mode," +mode+
                "                            \nString deviceId,"+deviceId +
                "                            \nString mymessage," +mymessage+
                "                            \nboolean ifRegister," +ifRegister+
                "                            \nString stdate,"+stdate +
                "                            \nString sttime," +sttime+
                "                            \nInteger timelong      "+timelong);
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date starttime=formatter.parse(stdate+" "+sttime);
        Date endtime = formatter.parse(stdate+" "+sttime);;
        endtime.setTime(endtime.getTime()+timelong*60*1000);
        System.out.println("sttime:"+starttime+"endtime:"+endtime);
        Scene scene = new Scene();
        scene.setSceneID(makeSceneID());
        scene.setOriginatorID(originatorID);
        scene.setTheme(theme);
        scene.setDeviceID(deviceId);
        scene.setMode(mode);
        if(ifRegister){
            scene.setIfRegister(1);
        }else{
            scene.setIfRegister(2);
        }
        scene.setMessage(mymessage);
        scene.setStartTime(starttime);
        scene.setEndTime(endtime);
        scene.setCreatTime(new Date());
        System.out.println(scene);
//        return scene.toString();
        return makeSceneService.MakeScene(scene);
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

}
