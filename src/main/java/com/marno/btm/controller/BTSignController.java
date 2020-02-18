package com.marno.btm.controller;

import com.marno.btm.service.btmSignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yz
 * @version 1.0
 * @date 2019/12/20 17:08
 */


@Controller
public class BTSignController {

    /**
     * 蓝牙签到请求
     * 需要参数：蓝牙信标id、会议id、登陆人id
     * 自己判断时间
     * @return
     */

    @Resource
    private btmSignService btmSignService;

    @RequestMapping("/btsign")
    @ResponseBody
    public Map btsign(String btId,String memberId){
        System.out.println("btid:"+btId+"memberID:"+memberId);
        Map map = new HashMap();
        map.put("sceneID",btmSignService.getSceneID(btId));
        if(btmSignService.AddMember(btId,memberId) == 1){
            map.put("status", 1);
            map.put("msg", "签到成功");
        }else if(btmSignService.AddMember(btId,memberId) == 2){
            map.put("status", 2);
            map.put("msg", "没有绑定场景");
        }else if(btmSignService.AddMember(btId,memberId) == 3){
            map.put("status", 3);
            map.put("msg", "该场景需要报名，请联系组织人员报名");
        }else {
            map.put("status", 1);
            map.put("msg", "已签到，不要重复签到");
        }

        return map;
    }
}