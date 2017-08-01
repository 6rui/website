package com.scdkay.website.service.impl;

import com.scdkay.website.base.BaseService;
import com.scdkay.website.repo.CaseRepository;
import com.scdkay.website.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 案例相关的业务层
 * Created by liurui on 2017/7/26.
 */
@Service
public class CaseServiceImpl extends BaseService implements CaseService {
    @Autowired
    private CaseRepository caseRepository;
}
