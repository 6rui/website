package com.scdkay.website.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志工具类
 * Created by liurui on 2017/7/17.
 */
public class LoggerUtil {
    private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    /**
     * 打印输出日志信息
     *
     * @param str    提示信息
     * @param object 打印内容
     */
    public static void info(String str, Object object) {
        /*** 获取输出信息的代码的位置 ***/
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        String location = stacks[2].getClassName() + "." + stacks[2].getMethodName()
                + "(" + stacks[2].getLineNumber() + ")";
        logger.info(str, object);
    }

    /**
     * 打印输出日志信息 重载方法
     *
     * @param str 提示信息
     */
    public static void info(String str) {
        logger.info(str);
    }

    /**
     * 打印输出异常信息
     *
     * @param str    提示信息
     * @param object 打印异常内容
     */
    public static void error(String str, Object object) {
        logger.error(str, object);
    }

    /**
     * 打印输出异常信息
     *
     * @param str 提示信息
     */
    public static void error(String str) {
        logger.error(str);
    }
}
