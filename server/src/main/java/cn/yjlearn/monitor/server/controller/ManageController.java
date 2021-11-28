package cn.yjlearn.monitor.server.controller;

import cn.hutool.core.util.RuntimeUtil;
import cn.yjlearn.monitor.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/manage")
@RestController
public class ManageController {

    @GetMapping("/call")
    public Result<String> call(@RequestParam String cmd) {
        String s = RuntimeUtil.execForStr(cmd);
        return Result.success(s);
    }

}
