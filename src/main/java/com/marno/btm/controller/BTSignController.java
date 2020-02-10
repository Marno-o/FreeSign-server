package com.marno.btm.controller;

import com.marno.btm.service.btmSignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author yz
 * @version 1.0
 * @date 2019/12/20 17:08
 */


@Controller
public class BTSignController {

    /**
     * 蓝牙签到请求
     * 需要参数：蓝牙信标id、会议id、登陆人id
     * 自己判断时间
     * @return
     */

    @Resource
    private btmSignService btmSignService;

    @RequestMapping("/btsign")
    @ResponseBody
    public String btsign(@RequestBody Map<String, Integer> member){
        int btId = member.get("btId");
        int memberId = member.get("memberId");
        return btmSignService.AddMember(btId,memberId);
    }
}