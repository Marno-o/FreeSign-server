package com.marno.btm.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author 叶勇
 * @version 1.0
 * @date 2020/2/11 21:35
 */

@Mapper
public interface getUserMapper {
    void newUser(Map map);
    Map getUser(String openID);
}
