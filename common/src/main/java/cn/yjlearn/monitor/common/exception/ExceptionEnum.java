package cn.yjlearn.monitor.common.exception;

public enum ExceptionEnum {

    //---调用侧错误
    WrongParams(1001, "请检查参数"),


    //---系统运行侧错误
    SystemError(9001, "系统内部错误"),

    ;

    private final int code;
    private final String msg;

    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
