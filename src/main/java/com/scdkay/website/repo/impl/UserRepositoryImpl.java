package com.scdkay.website.repo.impl;

import com.scdkay.website.base.BaseRepository;
import com.scdkay.website.entity.UserEntity;
import com.scdkay.website.repo.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户信息的数据库操作层
 * Created by liurui on 2017/7/12.
 */
@Repository
@SuppressWarnings("unchecked")
public class UserRepositoryImpl extends BaseRepository<UserEntity> implements UserRepository {

    @Override
    public List<UserEntity> findUserByUserName(String userName) {
        return getCurrentSession()
                .createQuery("FROM UserEntity user WHERE user.userName = :userName")
                .setParameter("userName", userName)
                .list();
    }
}
