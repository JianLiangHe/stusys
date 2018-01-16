package edu.stusys.controll.user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.stusys.dto.ValueDto;
import edu.stusys.model.User;
import edu.stusys.service.user.ILoginService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 处理用户登录的控制层
 * Created by Administrator on 2018/1/12.
 */
@Controller("loginControll")
@Scope("prototype")
public class LoginControll extends ActionSupport {

    private User user;
    private ValueDto valueDto;
    //声明业务层
    @Resource(name = "loginService")
    private ILoginService loginService;

    //1,处理用户登录的请求
    public String doLogin(){
        if(user!=null){
            user = loginService.doLogin(user);
            if(user!=null){
                ActionContext.getContext().getSession().put("loginUser",user);
                return "success";
            }
        }
        addActionError("用户名与密码有误");
        return "input";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ValueDto getValueDto() {
        return valueDto;
    }

    public void setValueDto(ValueDto valueDto) {
        this.valueDto = valueDto;
    }

    public void setLoginService(ILoginService loginService) {
        this.loginService = loginService;
    }
}
