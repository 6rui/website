package com.scdkay.website.controller;

import com.scdkay.website.base.BaseController;
import com.scdkay.website.entity.ResultEntity;
import com.scdkay.website.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 产品信息相关的控制器
 * Created by liurui on 2017/7/24.
 */
@Controller
@RequestMapping(value = "/production")
public class ProductionController extends BaseController {

    @Autowired
    private ProductionService productionService;

    /**
     * 分页获取产品分类的列表
     *
     * @return 产品分类实体的集合
     */
    @RequestMapping(value = "/category/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity getProductionCategoryList(int pageIndex, int pageSize) {
        return productionService.getProductionCategoryList();
    }

    /**
     * 分页获取产品的列表
     *
     * @return 产品实体的集合
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity getProductionListByPage(int pageIndex, int pageSize) {
        return productionService.getProductionListByPage(pageIndex, pageSize);
    }

    /**
     * 分页获取指定类别id的产品的列表
     *
     * @return 产品实体的集合
     */
    @RequestMapping(value = "/{categoryId}/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity getProductionListByPage(@PathVariable Integer categoryId, int pageIndex, int pageSize) {
        return productionService.getProductionListByCategoryIdAndPage(categoryId, pageIndex, pageSize);
    }
}
