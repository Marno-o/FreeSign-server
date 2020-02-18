package com.marno.btm.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface btmSignMapper {

    /**
     * 先根据信标ID找到场景ID
     */
    String getScene(String btID, Date nowTime);

    /**
     *签到
     **/
    void addMember(String sceneID, String  memberID, Date signTime);

    /**
     * 是否需要报名
     */
    Integer IfRegister(String sceneID);

    /**
     * 获取报名状态
     */
    Integer getState(String memberID,String sceneID);
}
