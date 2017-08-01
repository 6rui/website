package com.scdkay.website.controller;

import com.scdkay.website.base.BaseController;
import com.scdkay.website.entity.ResultEntity;
import com.scdkay.website.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 案例信息控制器
 * Created by liurui on 2017/7/24.
 */
@Controller
@RequestMapping(value = "/case")
public class CaseController extends BaseController {
    @Autowired
    private CaseService caseService;

    /**
     * 获取公司案例的列表
     *
     * @return 新闻分类实体的集合
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity getCategoryList() {
        return null;
    }
}
