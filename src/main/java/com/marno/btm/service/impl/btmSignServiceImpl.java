package com.marno.btm.service.impl;

import com.marno.btm.service.btmSignService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class btmSignServiceImpl implements btmSignService {

    @Resource
    private com.marno.btm.mapper.btmSignMapper btmSignMapper;

    @Override
    public String AddMember(String btID, int memberID) {
        Date signTime = new Date();
        btmSignMapper.addMenber(btmSignMapper.getScene(btID),memberID,signTime);
        return "签到成功！";
    }
}
