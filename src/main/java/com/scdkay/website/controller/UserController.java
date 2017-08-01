package com.scdkay.website.controller;

import com.scdkay.website.base.BaseController;
import com.scdkay.website.entity.ResultEntity;
import com.scdkay.website.entity.UserEntity;
import com.scdkay.website.service.UserService;
import com.scdkay.website.utils.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户相关的控制器
 * Created by liurui on 2017/7/13.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    /**
     * 登录请求的控制方法
     *
     * @param userEntity 封装用户名与密码
     * @return 返回用户的信息
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity login(UserEntity userEntity) {
        LOGGER.info("登录的用户名：" + userEntity.getUserName());
        LOGGER.info("登录的密码：" + userEntity.getPassword());
        return userService.login(userEntity);
    }

    /**
     * 用户注销
     *
     * @return 返回注销信息
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity logout() {
        LOGGER.info("用户[" + AuthUtil.getUserName() + "]退出登录！");
        return userService.logout();
    }
}
