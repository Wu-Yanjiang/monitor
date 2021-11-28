package cn.yjlearn.monitor.common.result;

import cn.yjlearn.monitor.common.exception.BizException;
import cn.yjlearn.monitor.common.exception.ExceptionEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public final class Result<T> implements Serializable {

    private static final long serialVersionUID = 1977164668324719263L;

    private int code;

    private String msg;

    private T data;

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setMsg("SUCCESS");
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setMsg("SUCCESS");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(BizException e) {
        Result<T> result = new Result<>();
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());
        return result;
    }

    public static <T> Result<T> fail(ExceptionEnum e) {
        Result<T> result = new Result<>();
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());
        return result;
    }

}
