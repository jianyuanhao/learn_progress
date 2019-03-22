package com.joy.fresh.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by jianyuanhao on 16-8-18.
 */
public class CompareInfo {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    /**
     * id
     */
    private Integer id;

    /**
     * 实施对比时间
     */
    private DateTime compareTime;
    /**
     * 源文件内容
     */
    private String sourceContext;
    /**
     * 目标文件内容
     */
    private String targetContext;
    /**
     * 差异
     */
    private String diffContext;

    public CompareInfo() {
    }

    public CompareInfo(DateTime compareTime, String sourceContext, String targetContext, String diffContext) {
        this.compareTime = compareTime;
        this.sourceContext = sourceContext;
        this.targetContext = targetContext;
        this.diffContext = diffContext;
    }

    @Override
    public String toString() {

            return "对比信息：{" + "id:" + id + ", sourceContext:" + sourceContext + ", targetContext:" +targetContext + ", 对比时间：" + compareTime
                    + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DateTime getCompareTime() {
        return compareTime;
    }

    public String getCompareTimeString() {
        return this.compareTime.toString(DATE_TIME_FORMATTER);
    }

    public void setCompareTime(DateTime compareTime) {
        this.compareTime = compareTime;
    }

    public String getSourceContext() {
        return sourceContext;
    }

    public void setSourceContext(String sourceContext) {
        this.sourceContext = sourceContext;
    }

    public String getTargetContext() {
        return targetContext;
    }

    public void setTargetContext(String targetContext) {
        this.targetContext = targetContext;
    }

    public String getDiffContext() {
        return diffContext;
    }

    public void setDiffContext(String diffContext) {
        this.diffContext = diffContext;
    }
}
