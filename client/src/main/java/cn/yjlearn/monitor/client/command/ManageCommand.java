package cn.yjlearn.monitor.client.command;

import cn.hutool.core.lang.Validator;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.yjlearn.monitor.client.common.GlobalVariables;
import cn.yjlearn.monitor.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

@Slf4j
@ShellComponent
public class ManageCommand {

    @Resource
    private GlobalVariables globalVariables;

    @ShellMethod("Execute a command in remote server.")
    public String call(String cmd, String... args) {
        StringBuilder cmdAndArgs= new StringBuilder(cmd);
        if (Validator.isNotEmpty(args)) {
            for (String arg : args) {
                cmdAndArgs.append(" ").append(arg);
            }
        }
        String execResult = HttpUtil.get(globalVariables.getRemoteCmdAddr(), Map.of("cmd", cmdAndArgs.toString()));
        JSONObject jsonObject = JSONUtil.parseObj(execResult);
        var result = JSONUtil.toBean(jsonObject, Result.class);
        if (0 != result.getCode()) {
            return result.getMsg();
        }
        return result.getData().toString();
    }

}
