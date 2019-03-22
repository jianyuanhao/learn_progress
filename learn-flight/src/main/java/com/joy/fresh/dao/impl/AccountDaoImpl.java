package com.joy.fresh.dao.impl;

import java.util.Properties;

import javax.annotation.Resource;

import com.joy.fresh.dao.AccountDao;
import org.springframework.stereotype.Component;

import com.joy.fresh.model.AccountInfo;

/**
 * 使用RootConfig中装配的实现查询，返回一个带密码的AccountInfo 对象返回
 * Created by jianyuanhao on 16-8-18.
 */
@Component("accountDaoImpl")
public class AccountDaoImpl implements AccountDao {

    @Resource(name = "accountProperties")
    private Properties accountProperties;

    @Override
    public AccountInfo queryAccountInfo(String userName) {
        AccountInfo accountInfo = new AccountInfo(userName, null);
        if (accountProperties.containsKey(userName)) {
            accountInfo.setPassword(accountProperties.getProperty(userName));
        }
        return accountInfo;
    }
}
