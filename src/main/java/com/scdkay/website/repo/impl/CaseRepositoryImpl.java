package com.scdkay.website.repo.impl;

import com.scdkay.website.base.BaseRepository;
import com.scdkay.website.entity.CaseEntity;
import com.scdkay.website.repo.CaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 案例信息相关的数据操作层
 * Created by liurui on 2017/7/26.
 */
@Repository
public class CaseRepositoryImpl extends BaseRepository<CaseEntity> implements CaseRepository {
}
