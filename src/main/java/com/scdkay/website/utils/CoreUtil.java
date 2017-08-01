package com.scdkay.website.utils;

import java.util.Collection;
import java.util.Map;

/**
 * 核心工具类
 * Created by liurui on 2017/7/10.
 */
public class CoreUtil {
    /**
     * 判断传来的参数是否是空的或者空的对象 参数是可变参数 ，可变参数中如果有一个是空或者空的对象，那么也返回true
     *
     * @param objs 待判断的对象
     * @return null或者空的对象都返回true 不为空返回false
     */
    @SuppressWarnings("Since15")
    public static boolean isNullOrEmpty(Object... objs) {
        if (objs == null) {
            return true;
        }

        for (Object obj : objs) {
            if (null == obj) {
                return true;
            }
            if (obj instanceof CharSequence) {
                if (obj instanceof String) {
                    if (!((String) obj).trim().isEmpty()) {
                        continue;
                    }
                    return true;
                }
                if (((CharSequence) obj).length() != 0) {
                    continue;
                } else {
                    return true;
                }
            }

            if (obj instanceof Collection) {
                if (!(((Collection<?>) obj).isEmpty())) {
                    continue;
                }
                return ((Collection<?>) obj).isEmpty();
            }

            if (obj instanceof Map) {
                if (!(((Map<?, ?>) obj).isEmpty())) {
                    continue;
                }
                return true;
            }

            if (obj instanceof Object[]) {
                Object[] object = (Object[]) obj;
                if (object.length == 0) {
                    return true;
                }
                boolean empty = true;
                for (int i = 0; i < object.length; i++) {
                    if (!isNullOrEmpty(object[i])) {
                        empty = false;
                        break;
                    }
                }
                if (empty) {
                    return empty;
                }
            }
        }
        return false;
    }
}
