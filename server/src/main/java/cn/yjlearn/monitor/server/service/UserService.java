package cn.yjlearn.monitor.server.service;

import cn.yjlearn.monitor.server.common.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    GlobalVariables globalVariables;

    @Autowired
    public void setGlobalVariables(GlobalVariables global) {
        this.globalVariables = global;
    }


    public String login(String user, String pwd) {

        return "";
    }


}
