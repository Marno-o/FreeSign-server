package com.marno.btm.service.impl;

import com.marno.btm.entity.Scene;
import com.marno.btm.service.GetSceneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 叶勇
 * @version 1.0
 * @date 2020/2/16 23:44
 */

@Service
public class GetSceneServiceImpl implements GetSceneService {
    @Resource
    private com.marno.btm.mapper.getSceneMapper getSceneMapper;


    @Override
    public Scene getScene(String sceneID){
        Scene scene = getSceneMapper.getScene(sceneID);
        return scene;
    }

    @Override
    public List<Map> getSceneListReady(String originatorID) {
        Date nowTime = new Date();
        List<Map> map = getSceneMapper.getSceneList(originatorID,nowTime);
        return map;
    }

    @Override
    public List<Map> getSceneListDone(String originatorID) {
        Date nowTime = null;
        List<Map> map = getSceneMapper.getSceneList(originatorID,nowTime);
        return map;
    }

}
