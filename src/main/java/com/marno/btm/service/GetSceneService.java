package com.marno.btm.service;

import com.marno.btm.entity.Scene;

import java.util.List;
import java.util.Map;

/**
 * @author 叶勇
 * @version 1.0
 * @date 2020/2/16 23:44
 */
public interface GetSceneService {
    public Scene getScene(String sceneID);

    public List<Map> getSceneListReady(String originatorID);

    public List<Map> getSceneListDone(String originatorID);
}
