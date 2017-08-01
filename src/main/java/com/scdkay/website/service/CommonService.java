package com.scdkay.website.service;

import com.scdkay.website.base.IBaseService;
import com.scdkay.website.entity.ResultEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * 公用业务层管理器接口
 * Created by liurui on 2017/7/20.
 */
public interface CommonService extends IBaseService {
    ResultEntity upload(Integer fileType, Integer isCover, HttpServletRequest request);
}
