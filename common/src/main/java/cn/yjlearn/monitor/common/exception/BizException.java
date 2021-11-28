package cn.yjlearn.monitor.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -5019253895602269815L;

    private int code;

    private String msg;

    public BizException(ExceptionEnum e) {
        this.code = e.getCode();
        this.msg = e.getMsg();
    }

    @Override
    public String toString() {
        return "code:" + code + ", msg:" + msg;
    }


}
