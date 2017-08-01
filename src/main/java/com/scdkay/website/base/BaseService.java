package com.scdkay.website.base;

import com.scdkay.website.constant.HttpStatus;
import com.scdkay.website.entity.ResultEntity;
import com.scdkay.website.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 业务层基类
 * Created by liurui on 2017/7/18.
 */
public class BaseService implements IBaseService {
    //日志记录
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);
    //日期格式
    protected static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 生成成功的返回实例
     *
     * @param object 封装的实体类
     * @return 包装后的结果
     */
    protected ResultEntity generateSucceedResult(Object object) {
        return new ResultEntity<>(HttpStatus.SUCCESS.getCode(),
                HttpStatus.SUCCESS.getMessage(),
                DateUtil.currentDate(TIME_FORMAT),
                object);
    }

    /**
     * 生成成功的返回实例 重载方法
     *
     * @param msg    成功的提醒消息
     * @param object 封装的实体类
     * @return 包装后的结果 成功
     */
    protected ResultEntity generateSucceedResult(String msg, Object object) {
        return new ResultEntity<>(HttpStatus.SUCCESS.getCode(),
                msg,
                DateUtil.currentDate(TIME_FORMAT),
                object);
    }

    /**
     * 生成失败的返回实例
     *
     * @param object 封装的实体类
     * @return 包装后的结果
     */
    protected ResultEntity generateFailureResult(Object object) {
        return new ResultEntity<>(HttpStatus.SUCCESS.getCode(),
                HttpStatus.SUCCESS.getMessage(),
                DateUtil.currentDate(TIME_FORMAT),
                object);
    }

    /**
     * 生成失败的返回实例 重载方法
     *
     * @param msg    失败的消息
     * @param object 封装的实体类
     * @return 包装后的结果
     */
    protected ResultEntity generateFailureResult(String msg, Object object) {
        return new ResultEntity<>(HttpStatus.SUCCESS.getCode(),
                HttpStatus.SUCCESS.getMessage(),
                DateUtil.currentDate(TIME_FORMAT),
                object);
    }
}
