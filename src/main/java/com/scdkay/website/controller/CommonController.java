package com.scdkay.website.controller;

import com.scdkay.website.base.BaseController;
import com.scdkay.website.entity.ResultEntity;
import com.scdkay.website.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 主控制器
 * Created by liurui on 2017/7/7.
 */
@Controller
public class CommonController extends BaseController {

    @Autowired
    private CommonService commonService;

    /**
     * 处理前端静态页面的跳转
     *
     * @param path 跳转路径
     * @return 返回视图解析器
     */
    @RequestMapping(value = "/{path}")
    public String gotoHtml(@PathVariable String path) {
        LOGGER.info("客户端跳转到[" + path + ".html]页面");
        return path;
    }

    /**
     * 文件上传
     *
     * @param request 请求信息封装
     * @param type    文件用途 0新闻相关文件，1产品图片，2案例图片，3产品功能的icon
     * @param isCover 是否为封面 0不是，1是
     * @return 返回视图解析器
     */
    @RequestMapping(value = "/file/upload")
    @ResponseBody
    public ResultEntity upload(Integer type, Integer isCover, HttpServletRequest request) {
        return commonService.upload(type, isCover, request);
    }
}
