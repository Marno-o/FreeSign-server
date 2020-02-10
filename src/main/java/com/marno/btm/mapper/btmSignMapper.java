package com.marno.btm.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface btmSignMapper {

    /**
     * 先根据信标ID找到场景ID
     */
    public String getScene(String btID);

    /**
     *签到
     **/
    public void addMenber(String sceneID, int memberID, Date signTime);
}
