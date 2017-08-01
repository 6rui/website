package com.scdkay.website.service;

import com.scdkay.website.base.IBaseService;
import com.scdkay.website.entity.NewsEntity;
import com.scdkay.website.entity.ResultEntity;

/**
 * 新闻中心业务层接口
 * Created by liurui on 2017/7/18.
 */
public interface NewsService extends IBaseService {
    ResultEntity getCategoryList();

    ResultEntity getNewsList(int size, int index);

    ResultEntity getDateList();

    ResultEntity getNewsListByDate(Integer year, Integer month, int pageIndex, int pageSize);

    ResultEntity getNewsListByDateAndCategory(Integer year, Integer month, Integer categoryId, int pageIndex, int pageSize);

    ResultEntity addNews(NewsEntity newsEntity);
}
