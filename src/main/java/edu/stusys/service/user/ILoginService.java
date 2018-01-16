package edu.stusys.service.user;

import edu.stusys.model.User;

/**
 * 定义登录业务的接口
 * Created by Administrator on 2018/1/12.
 */
public interface ILoginService {

    //用户登录
    User doLogin(User user);

}
