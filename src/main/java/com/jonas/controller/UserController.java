package com.jonas.controller;

import com.jonas.api.dto.User;
import com.jonas.api.service.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/getUser")
    public User getUser(Long uid) {
        return userApiService.getUser(uid);
    }

    @PostMapping("/test")
    public Integer test() {
        return userApiService.test();
    }

    @PostMapping("/getUserObject")
    public User getUserObject(Long id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return userApiService.getUserObject(user);
    }

}

