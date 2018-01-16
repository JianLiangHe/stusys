package edu.stusys.util;

import java.util.List;

/**
 * 分页Bean
 * Created by Administrator on 2018/1/12.
 */
public class PageBean {

    private int cpage = 1;//当前页
    private int showNum = 10;//每页显示数据条数
    private int allPage = 0;//总页数
    private int allNum = 0;//总数据条数

    private List result;//每页要显示的数据

    public PageBean() {
    }

    public PageBean(int cpage, int showNum, int allPage, int allNum, List result) {
        this.cpage = cpage;
        this.showNum = showNum;
        this.allPage = allPage;
        this.allNum = allNum;
        this.result = result;
    }

    public int getCpage() {
        return cpage;
    }

    public void setCpage(int cpage) {
        this.cpage = cpage;
    }

    public int getShowNum() {
        return showNum;
    }

    public void setShowNum(int showNum) {
        this.showNum = showNum;
    }

    public int getAllPage() {
        return allPage;
    }

    public void setAllPage(int allPage) {
        this.allPage = allPage;
    }

    public int getAllNum() {
        return allNum;
    }

    //设置总数据条数的方法
    public void setAllNum(int allNum) {
        //根据总数据条数计算页数
        this.allNum = allNum;
        if(this.allNum%this.showNum==0){
            this.allPage = this.allNum/this.showNum;
        }else{
            this.allPage = this.allNum/this.showNum+1;
        }
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }
}
