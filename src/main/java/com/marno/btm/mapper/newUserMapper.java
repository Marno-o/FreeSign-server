package com.marno.btm.mapper;

import com.marno.btm.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author 叶勇
 * @version 1.0
 * @date 2020/2/11 21:35
 */

@Mapper
public interface newUserMapper {
    void userIn(Map map);
    Integer ifsigned(String openid);
    Users getUser(String openid);
    void changeName(String newName, String openId);
}
