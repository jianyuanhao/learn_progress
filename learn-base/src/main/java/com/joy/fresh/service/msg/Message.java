package com.joy.fresh.service.msg;

/**
 * Created by jianyuanhao on 19-3-13.
 */
public class Message {
    private Integer id;
    private Integer bizId;
    private String bizType;
    private String bizData;
    private int status;

    public Message(Integer bizId, String bizType, String bizData, int status) {
        this.bizId = bizId;
        this.bizType = bizType;
        this.bizData = bizData;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBizId() {
        return bizId;
    }

    public void setBizId(Integer bizId) {
        this.bizId = bizId;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizData() {
        return bizData;
    }

    public void setBizData(String bizData) {
        this.bizData = bizData;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
