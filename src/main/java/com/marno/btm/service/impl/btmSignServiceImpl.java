package com.marno.btm.service.impl;

import com.marno.btm.service.btmSignService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class btmSignServiceImpl implements btmSignService {

    @Resource
    private com.marno.btm.mapper.btmSignMapper btmSignMapper;

    @Override
    public String AddMember(int btID, int memberID) {
        btmSignMapper.addMenber(btmSignMapper.getScene(btID),memberID);
        return "签到成功！";
    }
}
