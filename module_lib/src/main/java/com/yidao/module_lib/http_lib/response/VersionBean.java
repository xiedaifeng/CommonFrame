package com.yidao.module_lib.http_lib.response;

public class VersionBean {


    /**
     * remark : xxx版本
     * forceUpdate : 0
     * id : 3
     * type : 0
     * newest : 0
     * version : 1.0.2
     * url : http://xxxxx
     */

    private String remark;
    private String forceUpdate;
    private int id;
    private String type;
    private String newest;
    private String version;
    private String url;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(String forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNewest() {
        return newest;
    }

    public void setNewest(String newest) {
        this.newest = newest;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
