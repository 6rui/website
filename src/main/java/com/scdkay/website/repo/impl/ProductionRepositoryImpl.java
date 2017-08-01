package com.scdkay.website.repo.impl;

import com.scdkay.website.base.BaseRepository;
import com.scdkay.website.entity.ProductionEntity;
import com.scdkay.website.repo.ProductionRepository;
import org.springframework.stereotype.Repository;

/**
 * 产品的数据层
 * Created by liurui on 2017/7/24.
 */
@Repository
public class ProductionRepositoryImpl extends BaseRepository<ProductionEntity> implements ProductionRepository {
}
