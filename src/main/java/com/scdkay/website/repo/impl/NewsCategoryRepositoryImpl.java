package com.scdkay.website.repo.impl;

import com.scdkay.website.base.BaseRepository;
import com.scdkay.website.entity.NewsCategoryEntity;
import com.scdkay.website.repo.NewsCategoryRepository;
import org.springframework.stereotype.Repository;

/**
 * 新闻分类持久层实现类
 * Created by liurui on 2017/7/18.
 */
@Repository
public class NewsCategoryRepositoryImpl extends BaseRepository<NewsCategoryEntity> implements NewsCategoryRepository {
}
