package edu.stusys.dao;

import edu.stusys.util.PageBean;

/**
 * 定义基础数据操作的接口
 * Created by Administrator on 2018/1/12.
 */
public interface IBaseDao {

    //新增
    <T>boolean save(T t);

    //新增返回对象
    <T>T saveRutrn(T t);

    //删除
    <T>boolean delete(T t);

    //更新
    <T>boolean update(T t);

    //根据语句查询
    <T>T find(String hql);

    //分页查询
    <T>T find(String hql, PageBean pageBean);

}
