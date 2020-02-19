package com.marno.btm.service;

import com.marno.btm.entity.Users;

import java.util.Map;

/**
 * @author 叶勇
 * @version 1.0
 * @date 2020/2/11 21:30
 */

public interface GetUserService {
    void User2SQL(Map user);
    boolean ifsigned(String openid);
    Users SQL2User(String openid);
    String changeName(String newName, String openId);
}
