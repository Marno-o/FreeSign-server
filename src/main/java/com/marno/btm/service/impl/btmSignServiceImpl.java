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
    public int AddMember(String btID, String memberID) {
        Date signTime = new Date();
        String sceneID = getSceneID(btID);
        if(sceneID == null){
            return 2;
        }else if(btmSignMapper.IfRegister(sceneID) == 2) {//查询scene不需要报名
            if(btmSignMapper.getState(memberID,sceneID) == null){
                btmSignMapper.addMember(btmSignMapper.getScene(btID,new Date()), memberID, signTime);
                return 1;
            }else {
                return 0;
            }
        }else if(btmSignMapper.getState(memberID,sceneID) == null){//需要报名,未报名过
            return 3;
        }else if(btmSignMapper.getState(memberID,sceneID) == 1){//已报名
            btmSignMapper.addMember(btmSignMapper.getScene(btID,new Date()), memberID, signTime);
            return 1;
        }else{//已签到
            return 0;
        }
    }

    public String getSceneID(String btID){
        return btmSignMapper.getScene(btID,new Date());
    }
}
