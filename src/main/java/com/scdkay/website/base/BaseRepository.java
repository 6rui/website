package com.scdkay.website.base;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 提供基本数据库操作方法的实现
 * Created by liurui on 2017/7/12.
 *
 * @param <T>依赖的实体类
 */
@SuppressWarnings("unchecked")
public class BaseRepository<T> implements IBaseRepository<T, Integer> {
    //日志记录
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseRepository.class);
    private Class clazz = null;

    /**
     * 子类初始化的时候，拿到当前对象this已设置好了泛型的父类
     * BaseRepositoryImpl，此时的BaseRepositoryImpl应该是带好了确定的泛型的
     */
    protected BaseRepository() {
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) type;
            clazz = (Class) pType.getActualTypeArguments()[0];
        }
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public T load(Integer id) {
        return (T) getCurrentSession().load(Object.class, id);
    }

    @Override
    public T get(Integer id) {
        return (T) getCurrentSession().get(Object.class, id);
    }

    @Override
    public List<T> findAll() {
        StringBuffer hql = new StringBuffer("FROM ");
        hql.append(clazz.getSimpleName());
        hql.append(" WHERE status=0");
        return getCurrentSession().createQuery(hql.toString()).list();
    }

    @Override
    public List<T> findAllOrderBy(String columnName, String order) {
        StringBuffer hql = new StringBuffer("FROM ");
        hql.append(clazz.getSimpleName());
        hql.append(" WHERE status=0");
        hql.append(" ORDER BY ");
        hql.append(columnName);
        hql.append(" ");
        hql.append(order);
        return getCurrentSession().createQuery(hql.toString()).list();
    }

    @Override
    public List<T> findSomeOrderBy(String whereColumn, String value, String byColumnName, String order) {
        StringBuffer hql = new StringBuffer("FROM ");
        hql.append(clazz.getSimpleName());
        hql.append(" WHERE status=0 AND ");
        hql.append(whereColumn);
        hql.append(" ='");
        hql.append(value);
        hql.append("'");
        hql.append(" ORDER BY ");
        hql.append(byColumnName);
        hql.append(" ");
        hql.append(order);
        return getCurrentSession().createQuery(hql.toString()).list();
    }

    @Override
    public void persist(T entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public Integer save(T entity) {
        return (Integer) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Integer id) {
        Object obj = load(id);
        getCurrentSession().delete(obj);
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }


    public List<T> findSomeBy(String column, String value) {

        StringBuffer hql = new StringBuffer("FROM ");
        hql.append(clazz.getSimpleName());
        hql.append(" WHERE status=0 AND ");
        hql.append(column);
        hql.append(" ='");
        hql.append(value);
        hql.append("'");
        return (List<T>) getCurrentSession().createQuery(hql.toString()).list();
    }

    public List<T> findAllByPage(int index, int size) {
        int first = index * size - size;
        int max = index * size;
        StringBuffer hql = new StringBuffer("FROM ");
        hql.append(clazz.getSimpleName());
        hql.append(" WHERE status=0");
        return (List<T>) getCurrentSession().createQuery(hql.toString()).setFirstResult(first).setMaxResults(max).list();
    }

    @Override
    public List<T> findSomeOrderByPage(String whereColumn, String value, String byColumnName, String order, int index, int size) {
        int first = index * size - size;
        int max = index * size;
        StringBuffer hql = new StringBuffer("FROM ");
        hql.append(clazz.getSimpleName());
        hql.append(" WHERE status=0 AND ");
        hql.append(whereColumn);
        hql.append(" =");
        hql.append(value);
        hql.append("");
        hql.append(" ORDER BY ");
        hql.append(byColumnName);
        hql.append(" ");
        hql.append(order);
        return getCurrentSession().createQuery(hql.toString()).setFirstResult(first).setMaxResults(max).list();
    }
}
