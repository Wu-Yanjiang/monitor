package cn.yjlearn.monitor.client.common;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class GlobalVariables {

    private String serverUrl = "http://localhost:8080";

    private String version = "/v1";

    private String authAddr = "/auth";

    private String cmdAddr = "/manage/call";


    public String getRemoteCmdAddr() {
        return serverUrl + version + cmdAddr;
    }

    public String getPermissionAddr() {
        return serverUrl + authAddr;
    }
}
