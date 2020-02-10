package com.marno.btm.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface btmSignMapper {

    /**
     * 先根据信标ID找到场景ID
     */
    public int getScene(int btID);

    /**
     *签到
     **/
    public void addMenber(int sceneID,int memberID);
}
