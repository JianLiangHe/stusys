package edu.stusys.service.classroom.impl;

import edu.stusys.dao.IBaseDao;
import edu.stusys.exception.ClassroomException;
import edu.stusys.model.Classroom;
import edu.stusys.service.classroom.IClassroomService;
import edu.stusys.util.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 班级业务的实现类
 * Created by Administrator on 2018/1/14.
 */
@Service("classroomService")
@Transactional(propagation = Propagation.REQUIRED)
public class ClassroomServiceImpl implements IClassroomService {

    //声明Dao层
    @Resource(name = "baseDao")
    private IBaseDao baseDao;

    /**
     * 新增班级
     * @param classroom
     * @return
     */
    @Override
    public void saveClassroom(Classroom classroom) {
        if(findClassroomByName(classroom.getName()).size()>0){
            throw new ClassroomException("该班级已经存在.");
        }
        baseDao.save(classroom);
    }

    /**
     * 根据班级名称查询
     * @param name
     * @return
     */
    @Override
    public List findClassroomByName(String name) {
        String hql = "FROM Classroom WHERE name='"+name+"'";
        List list = baseDao.find(hql);
        return list;
    }

    /**
     * 查询所有班级
     * @return
     */
    @Override
    public List find() {
        return null;
    }

    /**
     * 分页带条件查询
     * @param pageBean
     * @param querys
     * @return
     */
    @Override
    public PageBean find(PageBean pageBean, String[] querys) {
        //构建hql语句
        String hql = "FROM Classroom WHERE 1=1";
        List list = baseDao.find(hql);
        pageBean.setAllNum(list.size());
        list = baseDao.find(hql,pageBean);
        pageBean.setResult(list);
        return pageBean;
    }

    public void setBaseDao(IBaseDao baseDao) {
        this.baseDao = baseDao;
    }
}
