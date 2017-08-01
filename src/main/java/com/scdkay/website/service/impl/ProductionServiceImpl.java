package com.scdkay.website.service.impl;

import com.scdkay.website.base.BaseService;
import com.scdkay.website.entity.ProductionEntity;
import com.scdkay.website.entity.ResultEntity;
import com.scdkay.website.repo.ProductionCategoryRepository;
import com.scdkay.website.repo.ProductionRepository;
import com.scdkay.website.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品业务层实现类
 * Created by liurui on 2017/7/24.
 */
@Service
public class ProductionServiceImpl extends BaseService implements ProductionService {
    @Autowired
    private ProductionRepository productionRepository;
    @Autowired
    private ProductionCategoryRepository productionCategoryRepository;

    @Override
    public ResultEntity getProductionListByPage(int pageIndex, int pageSize) {
        List<ProductionEntity> productionEntities = productionRepository.findAllByPage(pageIndex, pageSize);
        return generateSucceedResult(productionEntities);
    }

    @Override
    public ResultEntity getProductionListByCategoryIdAndPage(Integer categoryId, int pageIndex, int pageSize) {
        List<ProductionEntity> productionEntities = productionRepository.findSomeOrderByPage("category_id"
                , String.valueOf(categoryId)
                , "publish_time"
                , "DESC", pageIndex, pageSize);
        return generateSucceedResult(productionEntities);
    }

    @Override
    public ResultEntity getProductionCategoryList() {
        return null;
    }
}
