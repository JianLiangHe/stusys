package edu.stusys.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 封装用户信息的实体类
 * Created by Administrator on 2018/1/12.
 */
@Entity
@Table(name = "stusys_user")
public class User implements Serializable {

    @Column(name = "user_no")
    private String no;//编号
    @Column(name = "user_username",unique = true,nullable = false)
    private String username;//用户名
    @Column(name = "user_password",nullable = false)
    private String password;//密码
    @Column(name = "user_role")
    private int role;//角色
    @Column(name = "user_createtime",nullable = false)
    private Date createtime;//创建时间
    @Column(name = "user_status")
    private int status = 1;//状态 1:启用 0:禁用

    public User() {
    }

    public User(String no, String username, String password, int role, Date createtime, int status) {
        this.no = no;
        this.username = username;
        this.password = password;
        this.role = role;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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
