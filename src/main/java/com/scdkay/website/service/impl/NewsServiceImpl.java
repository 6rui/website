package com.scdkay.website.service.impl;

import com.scdkay.website.base.BaseService;
import com.scdkay.website.entity.NewsCategoryEntity;
import com.scdkay.website.entity.NewsEntity;
import com.scdkay.website.entity.ResultEntity;
import com.scdkay.website.repo.NewsCategoryRepository;
import com.scdkay.website.repo.NewsRepository;
import com.scdkay.website.service.NewsService;
import com.scdkay.website.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

/**
 * 新闻中心业务层实现类
 * Created by liurui on 2017/7/18.
 */
@Service
public class NewsServiceImpl extends BaseService implements NewsService {
    @Autowired
    private NewsCategoryRepository newsCategoryRepository;

    @Autowired
    private NewsRepository newsRepository;


    @Override
    public ResultEntity getCategoryList() {
        List<NewsCategoryEntity> newsCategoryEntities = newsCategoryRepository.findAllOrderBy("order", "ASC");
        return generateFailureResult(newsCategoryEntities);
    }

    @Override
    public ResultEntity getNewsList(int index, int size) {
//        List<NewsEntity> newsEntities = newsRepository.findSomeOrderByPage("pictureEntities.linkedId","0","publishTime","DESC",index, size);
        List<NewsEntity> newsEntities = newsRepository.getNewsAllInfoListByPage(index, size);
        return generateSucceedResult(newsEntities);
    }

    @Override
    public ResultEntity getDateList() {
        List<NewsEntity> newsEntities = newsRepository.findAllOrderBy("publish_time", "ASC");
        Map<String, Set<String>> yearAndMonth = new HashMap<>();
        Set<String> currYearOfMonths;
        if (CollectionUtil.isNotEmpty(newsEntities)) {
            for (NewsEntity newsEntity : newsEntities) {
                Timestamp publishTime = newsEntity.getPublishTime();
                if (null != publishTime) {
                    String year = publishTime.getYear() + 1900 + "年";
                    currYearOfMonths = yearAndMonth.get(year);
                    if (CollectionUtil.isEmpty(currYearOfMonths)) {
                        currYearOfMonths = new LinkedHashSet<>();
                    }
                    String month = publishTime.getMonth() + 1 + "月";
                    currYearOfMonths.add(month);
                    yearAndMonth.put(year, currYearOfMonths);
                }
            }
        }
        if (0 != yearAndMonth.size()) {
            List<Map<String, Object>> newsPublishDates = new ArrayList<>();
            for (Map.Entry<String, Set<String>> entry : yearAndMonth.entrySet()) {
                HashMap<String, Object> yearOfMonthMap = new HashMap<>();
                yearOfMonthMap.put("month_list", entry.getValue());
                yearOfMonthMap.put("year", entry.getKey());
                newsPublishDates.add(yearOfMonthMap);
            }
            return generateSucceedResult(newsPublishDates);
        }
        return null;
    }

    @Override
    public ResultEntity getNewsListByDate(Integer year, Integer month, int pageIndex, int pageSize) {
        String startDate = year + "-" + month + "-" + "1 00:00:00";
        String endDate = year + "-" + month + "-" + "31 23:59:59";
        List<NewsEntity> newsEntities = newsRepository.getNewsAllInfoListByDateAndPage(startDate, endDate, pageIndex, pageSize);
        return generateSucceedResult(newsEntities);
    }

    @Override
    public ResultEntity getNewsListByDateAndCategory(Integer year, Integer month, Integer categoryId, int pageIndex, int pageSize) {
        String startDate = year + "-" + month + "-" + "1 00:00:00";
        String endDate = year + "-" + month + "-" + "31 23:59:59";
        List<NewsEntity> newsEntities = newsRepository.getNewsAllInfoListByCategoryAndDateAndPage(startDate, endDate, categoryId, pageIndex, pageSize);
        return generateSucceedResult(newsEntities);
    }

    @Override
    @Transactional
    public ResultEntity addNews(NewsEntity newsEntity) {
        Integer saveCount = newsRepository.save(newsEntity);
        if (0 != saveCount) {
            return generateSucceedResult(newsEntity);
        }
        return generateFailureResult("新闻发布失败，请联系后台管理员！", null);
    }
}
