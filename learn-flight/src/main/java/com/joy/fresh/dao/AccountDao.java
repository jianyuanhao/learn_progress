package com.joy.fresh.dao;

import com.joy.fresh.model.AccountInfo;

/**
 * Created by jianyuanhao on 16-8-18.
 */

public interface AccountDao {
    public AccountInfo queryAccountInfo(String userName);
}
