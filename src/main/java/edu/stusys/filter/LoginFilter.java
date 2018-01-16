package edu.stusys.filter;

import edu.stusys.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录过滤器
 * Created by Administrator on 2018/1/12.
 */
public class LoginFilter implements Filter {

    //允许不用过滤的路径
    private String allowString = "/index.jsp,/userControll_doLogin.action";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //类型转换
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        //获取访问路径
        String requestPath = request.getServletPath();

        //过滤
        if(allowString.indexOf(requestPath)>=0){
            //放行
            filterChain.doFilter(request,response);
        }else{
            getLoginUser(request,response);
            filterChain.doFilter(request,response);
        }
        return;
    }

    private User getLoginUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取HttpSession,获取登录用户
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        if(user==null){
            PrintWriter out = response.getWriter();
            String url = request.getContextPath()+"/index.jsp";
            out.println("<script>alert('请先登录'); location.href='"+url+"';</script>");
            out.close();
        }
        return user;
    }

    @Override
    public void destroy() {

    }
}
