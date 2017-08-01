package com.scdkay.website.base;

import java.io.Serializable;
import java.util.List;

/**
 * 持久层基本接口
 * Created by liurui on 2017/7/18.
 */
public interface IBaseRepository<T, PK extends Serializable> {
    T load(PK id);

    T get(PK id);

    List<T> findAll();

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    void delete(PK id);

    void flush();

    /**
     * 依据传入的列名有序查询所有数据
     *
     * @param columnName 列名
     * @param order      DESC 降序  ASC 升序
     * @return 实体的集合
     */
    List<T> findAllOrderBy(String columnName, String order);

    /**
     * 依据传入的列名 有序 条件 查询数据
     *
     * @param whereColumn  条件查询的列名
     * @param value        条件查询的值
     * @param byColumnName 用于排序列名
     * @param order        DESC 降序  ASC 升序
     * @return 实体的集合
     */
    List<T> findSomeOrderBy(String whereColumn, String value, String byColumnName, String order);

    /**
     * 根据除主键外的列名 条件 查询数据
     *
     * @param column 列名
     * @param value  列名值
     * @return 查询结果集合
     */
    List<T> findSomeBy(String column, String value);

    /**
     * 分页查所有数据
     *
     * @param index 页码
     * @param size  每页大小
     * @return 查询结果的集合
     */
    List<T> findAllByPage(int index, int size);

    /**
     * 依据传入的列名 有序 条件 分页 查询数据
     *
     * @param whereColumn  条件查询的列名
     * @param value        条件查询的值
     * @param byColumnName 用于排序列名
     * @param order        DESC 降序  ASC 升序
     * @param index        页码
     * @param size         每页数量
     * @return 实体的集合
     */
    List<T> findSomeOrderByPage(String whereColumn, String value, String byColumnName, String order, int index, int size);

}
