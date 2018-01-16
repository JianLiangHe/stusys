package edu.stusys.dao.impl;

import edu.stusys.dao.IBaseDao;
import edu.stusys.factory.HbnSessionFactory;
import edu.stusys.util.PageBean;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * 处理基础数据操作的实现类
 * Created by Administrator on 2018/1/12.
 */
@Repository("baseDao")
public class BaseDaoImpl extends HbnSessionFactory implements IBaseDao {

    @Override
    public <T> boolean save(T t) {
        try{
            getSession().save(t);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public <T> T saveRutrn(T t) {
        try{
            getSession().save(t);
            return t;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> boolean delete(T t) {
        return false;
    }

    @Override
    public <T> boolean update(T t) {
        return false;
    }

    @Override
    public <T> T find(String hql) {
        return (T) getSession().createQuery(hql).list();
    }

    @Override
    public <T> T find(String hql, PageBean pageBean) {
        Query query = getSession().createQuery(hql);
        query.setFirstResult((pageBean.getCpage()-1)*pageBean.getShowNum());
        query.setMaxResults(pageBean.getShowNum());
        return (T) query.list();
    }
}
