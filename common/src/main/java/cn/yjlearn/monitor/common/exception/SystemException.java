package cn.yjlearn.monitor.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SystemException extends RuntimeException {
    private static final long serialVersionUID = 4659868469727100620L;

    private int code;

    private String msg;

    public SystemException(ExceptionEnum e) {
        this.code = e.getCode();
        this.msg = e.getMsg();
    }

    @Override
    public String toString() {
        return "code:" + code + ", msg:" + msg;
    }
}
