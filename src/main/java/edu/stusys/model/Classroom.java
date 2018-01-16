package edu.stusys.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 封装班级信息的实体类
 * Created by Administrator on 2018/1/14.
 */
@Entity
@Table(name = "stusys_classroom")
public class Classroom {

    @Column(name = "classroom_no")
    private String no;//编号
    @Column(name = "classroom_name",unique = true,nullable = false)
    private String name;//名称
    @Column(name = "classroom_createtime",nullable = false)
    private Date createtime;//创建时间
    @Column(name = "classroom_status",nullable = false)
    private int status = 1;//状态1:启用 0:禁用

    public Classroom() {
    }

    public Classroom(String no, String name, Date createtime, int status) {
        this.no = no;
        this.name = name;
        this.createtime = createtime;
        this.status = status;
    }

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
