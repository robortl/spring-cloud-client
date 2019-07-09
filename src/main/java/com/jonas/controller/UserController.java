package com.jonas.controller;

import com.jonas.api.dto.User;
import com.jonas.api.service.UserApiService;
import com.jonas.constant.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2019/01/08
 */
@RestController
@RequestMapping("/web/user")
public class UserController {

    @Autowired
    private UserApiService userApiService;

    @RequestMapping(value="/getUser")
    public User getUser(@RequestParam("uid")  Long uid) throws BizException {
        return userApiService.getUser(uid);
    }

    @PostMapping("/test")
    public Integer test() {
        return userApiService.test();
    }
}

