package edu.stusys.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 获取SessionFactory的工厂类
 * @author Administrator
 */
@Repository
public class HbnSessionFactory {

	//声明SessionFactory
	@Resource
	private SessionFactory sf;

	//获取Session
	public Session getSession(){
		return sf.getCurrentSession();
	}
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

}
