package com.gamecoder.util;

import java.util.HashMap;
import java.util.Map;

/**
 * ConfigEntry
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public class ConfigEntry {
    private Map<String,Object> data = new HashMap<>();

    public static ConfigEntry build(){
        return new ConfigEntry();
    }

    public ConfigEntry builder(String k, Object v){
        data.put(k,v);
        return this;
    }

    public boolean hasKey(String k){
        return data.containsKey(k);
    }

    public <T> T getValue(String k){
        return (T)data.get(k);
    }
}
