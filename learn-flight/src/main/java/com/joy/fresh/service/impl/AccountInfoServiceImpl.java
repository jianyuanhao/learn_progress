package com.joy.fresh.service.impl;

import javax.annotation.Resource;

import com.joy.fresh.dao.AccountDao;
import com.joy.fresh.service.AccountInfoService;
import org.springframework.stereotype.Service;

import com.joy.fresh.model.AccountInfo;

/**
 * 校验密码 Created by liujiakun on 16-6-18.
 */
@Service
public class AccountInfoServiceImpl implements AccountInfoService {
    @Resource
    AccountDao accountDaoImpl;

    @Override
    public boolean queryAccountInfo(AccountInfo accountInfo) {
        Boolean flag = false;
        AccountInfo accountInfo1 = accountDaoImpl.queryAccountInfo(accountInfo.getUserName());
        if (accountInfo.getPassword().equals(accountInfo1.getPassword())) {
            flag = true;
        }
        return flag;
    }
}
