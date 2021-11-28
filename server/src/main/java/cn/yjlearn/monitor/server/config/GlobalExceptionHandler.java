package cn.yjlearn.monitor.server.config;

import cn.yjlearn.monitor.common.exception.BizException;
import cn.yjlearn.monitor.common.exception.ExceptionEnum;
import cn.yjlearn.monitor.common.exception.SystemException;
import cn.yjlearn.monitor.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    public Result<Void> BizExceptionHandler(BizException e){
        log.info(e.toString());
        return Result.fail(e);
    }

    @ExceptionHandler(value = SystemException.class)
    public Result<Void> SystemExceptionHandler(BizException e){
        log.warn(e.toString());
        return Result.fail(ExceptionEnum.SystemError);
    }

    @ExceptionHandler(value = Exception.class)
    public Result<Void> exceptionHandler(Exception e){
        log.warn(e.toString());
        return Result.fail(ExceptionEnum.SystemError);
    }
}
