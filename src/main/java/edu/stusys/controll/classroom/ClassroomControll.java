package edu.stusys.controll.classroom;

import edu.stusys.controll.base.BaseControll;
import edu.stusys.dto.ValueDto;
import edu.stusys.exception.ClassroomException;
import edu.stusys.model.Classroom;
import edu.stusys.service.classroom.IClassroomService;
import edu.stusys.util.PageBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 班级请求的控制层
 * Created by Administrator on 2018/1/14.
 */
@Controller("classroomControll")
@Scope("prototype")
public class ClassroomControll extends BaseControll {

    private Classroom classroom;
    private ValueDto valueDto = null;
    private PageBean pageBean;
    private String[] querys;

    //声明业务层
    @Resource(name = "classroomService")
    private IClassroomService classroomService;

    //1,处理新增班级的请求
    public String doSaveClassroom(){
        if(classroom!=null){
            try{
                classroomService.saveClassroom(classroom);
                valueDto = success("新增班级成功");
            }catch(ClassroomException e){
                valueDto = error(500,e.getMessage());
            }
        }
        return "success";
    }

    //2,处理分页带条件查询班级列表的请求
    public String findClassroomForPage(){
        if(pageBean!=null){
            pageBean = classroomService.find(pageBean,querys);
        }
        return "main";
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public ValueDto getValueDto() {
        return valueDto;
    }

    public void setValueDto(ValueDto valueDto) {
        this.valueDto = valueDto;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public String[] getQuerys() {
        return querys;
    }

    public void setQuerys(String[] querys) {
        this.querys = querys;
    }

    public void setClassroomService(IClassroomService classroomService) {
        this.classroomService = classroomService;
    }
}
