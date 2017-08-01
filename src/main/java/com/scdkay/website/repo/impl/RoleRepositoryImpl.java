package com.scdkay.website.repo.impl;

import com.scdkay.website.base.BaseRepository;
import com.scdkay.website.entity.RoleEntity;
import com.scdkay.website.repo.RoleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色数据库操作层实现类
 * Created by liurui on 2017/7/14.
 */
@Repository
public class RoleRepositoryImpl extends BaseRepository<RoleEntity> implements RoleRepository {
    @Override
    public List<RoleEntity> findAllRole() {
        return findAll();
    }
}
