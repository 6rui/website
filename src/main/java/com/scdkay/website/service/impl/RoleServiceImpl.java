package com.scdkay.website.service.impl;

import com.scdkay.website.base.BaseService;
import com.scdkay.website.entity.RoleEntity;
import com.scdkay.website.repo.RoleRepository;
import com.scdkay.website.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色相关操作的业务层实现类
 * Created by liurui on 2017/7/14.
 */
@Service
public class RoleServiceImpl extends BaseService implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleEntity> findAllRole() {
        return roleRepository.findAllRole();
    }
}
