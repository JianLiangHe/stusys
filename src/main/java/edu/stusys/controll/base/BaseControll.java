package edu.stusys.controll.base;

import com.opensymphony.xwork2.ActionSupport;
import edu.stusys.dto.ValueDto;

/**
 * Created by Administrator on 2018/1/14.
 */
public class BaseControll extends ActionSupport {

    protected ValueDto success(Object obj){
        ValueDto valueDto = new ValueDto();
        valueDto.setValue(obj);
        return valueDto;
    }

    protected ValueDto error(int code,String message){
        ValueDto valueDto = new ValueDto();
        valueDto.setCode(code);
        valueDto.setMessage(message);
        return valueDto;
    }

}
