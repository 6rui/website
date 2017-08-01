package com.scdkay.website.service;

import com.scdkay.website.base.IBaseService;
import com.scdkay.website.entity.ResultEntity;

/**
 * 产品业务层接口
 * Created by liurui on 2017/7/24.
 */
public interface ProductionService extends IBaseService {
    ResultEntity getProductionListByPage(int pageIndex, int pageSize);

    ResultEntity getProductionListByCategoryIdAndPage(Integer categoryId, int pageIndex, int pageSize);

    ResultEntity getProductionCategoryList();

}
