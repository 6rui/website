package com.scdkay.website.controller;

import com.scdkay.website.base.BaseController;
import com.scdkay.website.entity.NewsEntity;
import com.scdkay.website.entity.ResultEntity;
import com.scdkay.website.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 新闻中心控制器
 * Created by liurui on 2017/7/18.
 */
@Controller
public class NewsController extends BaseController {
    @Autowired
    private NewsService newsService;

    /**
     * 获取新闻分类的列表
     *
     * @return 新闻分类实体的集合
     */
    @RequestMapping(value = "/news/category/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity getCategoryList() {
        return newsService.getCategoryList();
    }

    /**
     * 获取新闻日期列表
     *
     * @return 包含已有新闻的年月列表
     */
    @RequestMapping(value = "/news/date/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity getDateList() {
        return newsService.getDateList();
    }

    /**
     * 分页获取全部新闻信息
     *
     * @param pageIndex 页码
     * @param pageSize  每页数量
     * @return 新闻分类实体的集合
     */
    @RequestMapping(value = "/news/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity getNewsList(int pageIndex, int pageSize) {
        return newsService.getNewsList(pageIndex, pageSize);
    }

    /**
     * 分页获取指定月份的全部新闻信息
     *
     * @param pageIndex 页码
     * @param pageSize  每页数量
     * @return 新闻分类实体的集合
     */
    @RequestMapping(value = "/news/{year}/{month}/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity getNewsListByDate(@PathVariable Integer year, @PathVariable Integer month, int pageIndex, int pageSize) {
        return newsService.getNewsListByDate(year, month, pageIndex, pageSize);
    }

    /**
     * 分页获取指定月份的指定类型的新闻信息
     *
     * @param pageIndex 页码
     * @param pageSize  每页数量
     * @return 新闻分类实体的集合
     */
    @RequestMapping(value = "/news/{year}/{month}/{categoryId}/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity getNewsListByDateAndCategory(@PathVariable Integer year, @PathVariable Integer month, @PathVariable Integer categoryId, int pageIndex, int pageSize) {
        return newsService.getNewsListByDateAndCategory(year, month, categoryId, pageIndex, pageSize);
    }

    /**
     * 新增一条新闻
     *
     * @return 新闻分类实体的集合
     */
    @RequestMapping(value = "/news", method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity addNews(NewsEntity newsEntity) {
        return newsService.addNews(newsEntity);
    }
}
