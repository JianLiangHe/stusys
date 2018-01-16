package edu.stusys.dto;

/**
 * 数据传输对象
 * Created by Administrator on 2018/1/12.
 */
public class ValueDto {

    //响应状态码
    private int code = 200;
    //异常消息
    private String message;
    //传输的数据
    private Object value;

    public ValueDto() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
