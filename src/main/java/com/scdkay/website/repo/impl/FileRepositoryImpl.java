package com.scdkay.website.repo.impl;

import com.scdkay.website.base.BaseRepository;
import com.scdkay.website.entity.FileEntity;
import com.scdkay.website.repo.FileRepository;
import org.springframework.stereotype.Repository;

/**
 * 媒体文件相关数据持久层实现类
 * Created by liurui on 2017/7/20.
 */
@Repository
public class FileRepositoryImpl extends BaseRepository<FileEntity> implements FileRepository {
}
