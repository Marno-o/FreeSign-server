package com.marno.btm.service.impl;

import com.marno.btm.mapper.getUserMapper;
import com.marno.btm.service.GetUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 叶勇
 * @version 1.0
 * @date 2020/2/11 21:33
 */

@Service
public class GetUserServiceImpl implements GetUserService {

    @Resource
    private getUserMapper getUserMapper;

    @Override
    public void User2SQL(Map user) {
        getUserMapper.newUser(user);
    }

    @Override
    public void SQL2User(String openID) {
        getUserMapper.getUser(openID);
    }
}
