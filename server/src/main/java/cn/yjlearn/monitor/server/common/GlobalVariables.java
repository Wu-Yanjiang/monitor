package cn.yjlearn.monitor.server.common;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import org.springframework.stereotype.Component;

@Component
public class GlobalVariables {

    public Cache<String, String> userSessionCache;

    public GlobalVariables() {
        userSessionCache = CacheUtil.newFIFOCache(100, 2 * 60 * 60 * 1000);
    }

}
