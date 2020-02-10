package com.marno.btm.mapper;

import com.marno.btm.entity.Scene;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 叶勇
 * @version 1.0
 * @date 2020/2/10 22:49
 */

@Mapper
public interface makeSceneMapper {
    /**
     * 创建场景
     */
    public void makeScene(Scene scene);

    /**
     * 创建场景表
     */
    public void makeSceneTable(String sceneID);

    /**
     *  检测重复
     */
    public Integer createTwice(String serviceID);

}
