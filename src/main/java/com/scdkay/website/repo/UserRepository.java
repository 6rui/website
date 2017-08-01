package com.scdkay.website.repo;

import com.scdkay.website.base.IBaseRepository;
import com.scdkay.website.entity.UserEntity;

import java.util.List;

/**
 * 用户的数据库操作接口
 * Created by liurui on 2017/7/12.
 */
public interface UserRepository extends IBaseRepository<UserEntity, Integer> {
    /**
     * 根据前端页面登录用户名查询用户信息交由业务层处理
     *
     * @param userName 登录的用户名
     * @return 用户信息
     */
    List<UserEntity> findUserByUserName(String userName);
}
