package com.scdkay.website.service.impl;

import com.scdkay.website.base.BaseService;
import com.scdkay.website.constant.HttpStatus;
import com.scdkay.website.entity.ResultEntity;
import com.scdkay.website.entity.UserEntity;
import com.scdkay.website.repo.UserRepository;
import com.scdkay.website.service.UserService;
import com.scdkay.website.utils.AuthUtil;
import com.scdkay.website.utils.CollectionUtil;
import com.scdkay.website.utils.DateUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户相关逻辑业务层实现类
 * Created by liurui on 2017/7/12.
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {
    @Autowired
    private UserRepository userRepository;

    public ResultEntity login(UserEntity userEntity) {
        ResultEntity<UserEntity> resultEntity;
        String userName = userEntity.getUserName();
        String password = userEntity.getPassword();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
        List<UserEntity> userEntities = userRepository.findUserByUserName(userName);
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            resultEntity = new ResultEntity<>(HttpStatus.FAILURE.getCode(),
                    "用户名不存在！",
                    DateUtil.currentDate(TIME_FORMAT),
                    null);
            return resultEntity;
        } catch (IncorrectCredentialsException e) {
            resultEntity = new ResultEntity<>(HttpStatus.FAILURE.getCode(),
                    "密码输入错误！",
                    DateUtil.currentDate(TIME_FORMAT),
                    null);
            return resultEntity;
        }
        resultEntity = new ResultEntity<>(HttpStatus.SUCCESS.getCode(),
                "登录成功！",
                DateUtil.currentDate(TIME_FORMAT),
                userEntities.get(0));
        return resultEntity;
    }

    @Override
    public ResultEntity logout() {
        try {
            AuthUtil.logout();
        } catch (Exception e) {
            return new ResultEntity<Object>(HttpStatus.FAILURE.getCode(),
                    "用户未登录！",
                    DateUtil.currentDate(TIME_FORMAT),
                    null);
        }
        return new ResultEntity<Object>(HttpStatus.SUCCESS.getCode(),
                "用户注销成功！",
                DateUtil.currentDate(TIME_FORMAT),
                null);
    }

    @Override
    public UserEntity findUserByUserName(String userName) {
        List<UserEntity> entityList = userRepository.findUserByUserName(userName);
        UserEntity userEntity = null;
        if (CollectionUtil.isNotEmpty(entityList)) {
            userEntity = entityList.get(0);
        }
        return userEntity;
    }


}
