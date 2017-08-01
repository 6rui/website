package com.scdkay.website.repo;

import com.scdkay.website.base.IBaseRepository;
import com.scdkay.website.entity.RoleEntity;

import java.util.List;

/**
 * 角色数据库操作层接口
 * Created by liurui on 2017/7/14.
 */
public interface RoleRepository extends IBaseRepository<RoleEntity,Integer> {
    List<RoleEntity> findAllRole();
}
