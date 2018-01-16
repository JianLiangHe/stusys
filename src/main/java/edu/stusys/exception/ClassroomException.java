package edu.stusys.exception;

/**
 * Created by Administrator on 2018/1/14.
 */
public class ClassroomException extends RuntimeException {

    public ClassroomException(String message) {
        super(message);
    }

    public ClassroomException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClassroomException(Throwable cause) {
        super(cause);
    }
}
