package com.marno.btm.controller;

import com.marno.btm.service.MakeSceneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
    public String makescene(@RequestParam("originatorID") int originatorID,
                            @RequestParam("mode")         int mode,
                            @RequestParam("serviceID")    String serviceID,
                            @RequestParam("theme")        String theme){
        return makeSceneService.MakeScene(originatorID,mode,serviceID,theme);
    }

}
