package com.scdkay.website.utils;

import java.util.Collection;

/**
 * 集合工具类
 * Created by liurui on 2017/7/10.
 */
public class CollectionUtil {

    /**
     * 判断当前列表是否为空
     *
     * @param collection 列表
     * @return true 空 false 非空
     */
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    /**
     * 判断当前列表是否不为空
     *
     * @param collection 集合
     * @return true 非空 false 空
     */
    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }
}
