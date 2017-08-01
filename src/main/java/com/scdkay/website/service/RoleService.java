package com.scdkay.website.service;

import com.scdkay.website.base.IBaseService;
import com.scdkay.website.entity.RoleEntity;

import java.util.List;

/**
 * 角色相关操作的业务层
 * Created by liurui on 2017/7/14.
 */
public interface RoleService extends IBaseService {
    List<RoleEntity> findAllRole();
}
