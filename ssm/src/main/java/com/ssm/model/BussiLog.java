package com.ssm.model;


import java.util.Date;

/**
 * Created by KaiLin.Guo on 2018-03-20.
 */
public class BussiLog {

    private Integer id;

    private Integer tableNo;

    private String opUser;

    private String remark;

    private String content;

    private Date createdTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTableNo() {
        return tableNo;
    }

    public void setTableNo(Integer tableNo) {
        this.tableNo = tableNo;
    }

    public String getOpUser() {
        return opUser;
    }

    public void setOpUser(String opUser) {
        this.opUser = opUser;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "BussiLog{" +
                "id=" + id +
                ", tableNo=" + tableNo +
                ", opUser='" + opUser + '\'' +
                ", remark='" + remark + '\'' +
                ", content='" + content + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
