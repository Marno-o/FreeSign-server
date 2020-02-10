package com.marno.btm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yz
 * @version 1.0
 */
@Controller
public class UserController {

    /**
     * 用户登录小程序
     * @return
     */
    @RequestMapping("/usersign")
    @ResponseBody
    public void index(){
        return ;
    }
}