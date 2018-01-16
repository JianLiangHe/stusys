package edu.stusys.service.classroom;

import edu.stusys.model.Classroom;
import edu.stusys.util.PageBean;

import java.util.List;

/**
 * 班级业务的接口
 * Created by Administrator on 2018/1/14.
 */
public interface IClassroomService {

    //新增班级
    void saveClassroom(Classroom classroom);

    //根据名称查询班级
    List findClassroomByName(String name);

    //查询
    List find();

    //分页查询
    PageBean find(PageBean pageBean,String[] querys);

}
