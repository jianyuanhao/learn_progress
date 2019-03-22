package com.joy.fresh.dao;

import java.util.List;

import com.joy.fresh.model.CompareInfo;
import org.apache.ibatis.session.RowBounds;

/**
 * 功能:与数据库相关操作
 * Created by jianyuanhao on 16-8-18.
 */
public interface CompareInfoDao {
    public int saveCompareInfo(CompareInfo compareInfo);

    public int queryCompareInfoCount();

    public List<CompareInfo> queryCompareInfos(RowBounds rowBounds);

    public int deleteCompareInfo(Integer id);
}
