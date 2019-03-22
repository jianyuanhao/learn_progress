package com.joy.fresh.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.joy.fresh.model.CompareInfo;

/**
 * Created by jianyuanhao on 16-8-18.
 */
public interface CompareInfoService {
    public int saveCompareInfo(InputStream sourceStream, InputStream targetStream) throws IOException;

    public int queryCompareInfoCount();

    public List<CompareInfo> queryCompareInfos(int start, int size);

    public int deleteCompareInfo(Integer id);
}
