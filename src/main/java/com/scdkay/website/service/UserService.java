package com.scdkay.website.service;

import com.scdkay.website.base.IBaseService;
import com.scdkay.website.entity.ResultEntity;
import com.scdkay.website.entity.UserEntity;

/**
 * 用户业务层处理接口
 * Created by liurui on 2017/7/12.
 */
public interface UserService extends IBaseService {
    ResultEntity login(UserEntity userEntity);

    ResultEntity logout();

    UserEntity findUserByUserName(String userName);

}
