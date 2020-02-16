package com.marno.btm.mapper;

import com.marno.btm.entity.Scene;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author 叶勇
 * @version 1.0
 * @date 2020/2/16 23:45
 */

@Mapper
public interface getSceneMapper {
    public Scene getScene(String sceneID);

    public List<Map> getSceneList(String originatorID);
}
