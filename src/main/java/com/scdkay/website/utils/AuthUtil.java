package com.scdkay.website.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class AuthUtil {

    /**
     * 获取当前登录的用户UserEntity对象
     *
     * @return 用户的信息
     */
    public static String getToken() {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        return (String) principal;
    }

    /**
     * 获取当前用户的Session
     *
     * @return 登录的session
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 获取当前用户名
     *
     * @return 用户名
     */
    public static String getUserName() {
        return getToken();
    }


    /**
     * 把值放入到当前登录用户的Session里
     *
     * @param key   存入的key
     * @param value 对应的值
     */
    public static void setVal2Session(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    /**
     * 从当前登录用户的Session里取值
     *
     * @param key key
     * @return 存入的value
     */
    public static Object getVal2Session(Object key) {
        return getSession().getAttribute(key);
    }


    /**
     * 判断是否登录
     *
     * @return true登录 false 未登录
     */
    public static boolean isLogin() {
        return null != SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 退出登录，并销魂用户数据
     */
    public static void logout() throws Exception {
        SecurityUtils.getSubject().logout();
    }


}