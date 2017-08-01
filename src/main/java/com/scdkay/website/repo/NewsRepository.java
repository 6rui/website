package com.scdkay.website.repo;

import com.scdkay.website.base.IBaseRepository;
import com.scdkay.website.entity.NewsEntity;

import java.util.List;

/**
 * 新闻相关的持久层接口
 * Created by liurui on 2017/7/19.
 */
public interface NewsRepository extends IBaseRepository<NewsEntity, Integer> {
    List<NewsEntity> getNewsAllInfoListByPage(int index, int size);

    List<NewsEntity> getNewsAllInfoListByDateAndPage(String startDate, String endDate, Integer pageIndex, Integer pageSize);

    List<NewsEntity> getNewsAllInfoListByCategoryAndDateAndPage(String startDate, String endDate, Integer categoryId, Integer pageIndex, Integer pageSize);
}
