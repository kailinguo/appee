package com.boot.web.entity;

/**
 * Created by KaiLin.Guo on 2017-10-16.
 */
public class JsonPTo {

    private Integer param_key;

    private String param_name;

    private String param_desc;

    private Integer param_value;

    private String param_unit;

    private Integer is_inactive;

    public Integer getParam_key() {
        return param_key;
    }

    public void setParam_key(Integer param_key) {
        this.param_key = param_key;
    }

    public String getParam_name() {
        return param_name;
    }

    public void setParam_name(String param_name) {
        this.param_name = param_name;
    }

    public String getParam_desc() {
        return param_desc;
    }

    public void setParam_desc(String param_desc) {
        this.param_desc = param_desc;
    }

    public Integer getParam_value() {
        return param_value;
    }

    public void setParam_value(Integer param_value) {
        this.param_value = param_value;
    }

    public String getParam_unit() {
        return param_unit;
    }

    public void setParam_unit(String param_unit) {
        this.param_unit = param_unit;
    }

    public Integer getIs_inactive() {
        return is_inactive;
    }

    public void setIs_inactive(Integer is_inactive) {
        this.is_inactive = is_inactive;
    }
}
