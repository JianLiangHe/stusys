package edu.stusys.service.user.impl;

import edu.stusys.dao.IBaseDao;
import edu.stusys.model.User;
import edu.stusys.service.user.ILoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 登录业务的实现类
 * Created by Administrator on 2018/1/12.
 */
@Service("loginService")
@Transactional(propagation = Propagation.REQUIRED)
public class LoginServiceImpl implements ILoginService {

    //声明Dao层
    @Resource(name = "baseDao")
    private IBaseDao baseDao;

    @Override
    public User doLogin(User user) {
        //构建hql语句
        String hql = "FROM User u"
                    + " WHERE u.username='"+user.getUsername()+"' AND u.status=1";
        //调用Dao层查询
        List<User> list = baseDao.find(hql);
        //遍历用户
        for(User u:list){
           if(user.getUsername().equals(u.getUsername())&&user.getPassword().equals(u.getPassword())){
               return u;
           }
        }
        return null;
    }

    public void setBaseDao(IBaseDao baseDao) {
        this.baseDao = baseDao;
    }
}
