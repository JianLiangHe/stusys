package edu.stusys.util;

import org.apache.struts2.util.StrutsTypeConverter;

import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * 日期类型转换类
 * Created by Administrator on 2018/1/12.
 */
public class DateConversion extends StrutsTypeConverter {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
        if(arg1!=null&&arg1.length>0){
            if(arg1[0]!=null&&arg1[0].length()>0){
                try {
                    return sdf.parse(arg1[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public String convertToString(Map arg0, Object arg1) {
        return sdf.format(arg1);
    }
}
