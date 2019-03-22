package com.joy.fresh.model;

import org.joda.time.DateTime;

/**
 * Created by jianyuanhao on 16-8-18.
 */
public class CompareInfoBuilder {
    private DateTime compareTime;
    private String sourceContext;
    private String targetContext;
    private String diffContext;

    public CompareInfoBuilder setCompareTime(DateTime compareTime) {
        this.compareTime = compareTime;
        return this;
    }

    public CompareInfoBuilder setSourceContext(String sourceContext) {
        this.sourceContext = sourceContext;
        return this;
    }

    public CompareInfoBuilder setTargetContext(String targetContext) {
        this.targetContext = targetContext;
        return this;
    }

    public CompareInfoBuilder setDiffContext(String diffContext) {
        this.diffContext = diffContext;
        return this;
    }

    public CompareInfo createCompareInfo() {
        return new CompareInfo(compareTime, sourceContext, targetContext, diffContext);
    }
}