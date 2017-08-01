package com.scdkay.website.repo.impl;

import com.scdkay.website.base.BaseRepository;
import com.scdkay.website.entity.NewsEntity;
import com.scdkay.website.repo.NewsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 新闻相关数据的持久层实现类
 * Created by liurui on 2017/7/19.
 */
@Repository
@SuppressWarnings("unchecked")
public class NewsRepositoryImpl extends BaseRepository<NewsEntity> implements NewsRepository {
    @Override
    public List<NewsEntity> getNewsAllInfoListByPage(int index, int size) {
        int first = index * size - size;
        int max = index * size;
        String hql = "FROM NewsEntity news LEFT JOIN FETCH news.fileEntities newsPic " +
                "WHERE news.status=0 AND (newsPic.type = 0 OR newsPic.type IS NULL) AND (newsPic.status = 0 OR newsPic.status IS NULL) " +
                "ORDER BY " +
                "news.publishTime DESC";
        return getCurrentSession().createQuery(hql).setFirstResult(first).setMaxResults(max).list();
    }

    @Override
    public List<NewsEntity> getNewsAllInfoListByDateAndPage(String startDate, String endDate, Integer index, Integer size) {
        int first = index * size - size;
        int max = index * size;
        String hql = "FROM NewsEntity news LEFT JOIN FETCH news.fileEntities newsPic " +
                "WHERE news.status=0 AND (newsPic.type = 0 OR newsPic.type IS NULL) AND (newsPic.status = 0 OR newsPic.status IS NULL)" +
                "AND news.publishTime >= '" + startDate + "' " +
                "AND news.publishTime <= '" + endDate + "' " +
                "ORDER BY " +
                "news.publishTime DESC";
        return getCurrentSession().createQuery(hql).setFirstResult(first).setMaxResults(max).list();
    }

    @Override
    public List<NewsEntity> getNewsAllInfoListByCategoryAndDateAndPage(String startDate, String endDate, Integer categoryId, Integer index, Integer size) {
        int first = index * size - size;
        int max = index * size;
        String hql = "FROM NewsEntity news LEFT JOIN FETCH news.fileEntities newsPic " +
                "WHERE news.status=0 AND (newsPic.type = 0 OR newsPic.type IS NULL) AND (newsPic.status = 0 OR newsPic.status IS NULL)" +
                "AND news.publishTime >= '" + startDate + "' " +
                "AND news.publishTime <= '" + endDate + "' " +
                "AND news.categoryId=" + categoryId +
                " ORDER BY " +
                "news.publishTime DESC";
        return getCurrentSession().createQuery(hql).setFirstResult(first).setMaxResults(max).list();
    }
}
