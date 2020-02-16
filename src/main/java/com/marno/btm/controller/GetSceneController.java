package com.marno.btm.controller;

import com.marno.btm.entity.Scene;
import com.marno.btm.service.GetSceneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @author 叶勇
 * @version 1.0
 * @date 2020/2/16 23:22
 */
@Controller
public class GetSceneController {
    /**
     * 获取签到场景
     * 需要参数：签到方式、蓝牙信标ID、发起人ID
     */

    @Resource
    private GetSceneService getSceneService;

    @RequestMapping("/getscenebysid")//根据sceneid获取
    @ResponseBody
    public Scene getScene(String sceneID) throws ParseException {
        Scene scene = getSceneService.getScene(sceneID);
        return scene;
    }


    @RequestMapping("/getscenebyoid")//根据发起人id获取
    @ResponseBody
    public List<Map> getSceneList(String originatorID){
        List<Map> map = getSceneService.getSceneList(originatorID);
        return map;
    }
}
