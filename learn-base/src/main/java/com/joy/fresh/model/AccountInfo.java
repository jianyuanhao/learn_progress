package com.joy.fresh.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by jianyuanhao on 16-8-18.
 */
public class AccountInfo {

    @NotNull
    @Size(min = 1, max = 20, message = "长度：6～20")
    private String userName;
    @NotNull
    @Size(min = 6, max = 20, message = "长度：6～20之间")
    private String password;

    public AccountInfo() {
    }

    public AccountInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // @Override
    // public boolean equals(Object o) {
    // if (this == o) return true;
    // if (!(o instanceof AccountInfo)) return false;
    //
    // AccountInfo that = (AccountInfo) o;
    //
    // if (getUserName() != null ? !getUserName().equals(that.getUserName()) : that.getUserName() != null)
    // return false;
    // return getPassword() != null ? getPassword().equals(that.getPassword()) : that.getPassword() == null;
    //
    // }
    //
    // @Override
    // public int hashCode() {
    // int result = getUserName() != null ? getUserName().hashCode() : 0;
    // result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
    // return result;
    // }

    @Override
    public String toString() {
        return "AccountInfo{" + "userName='" + userName + '\'' + ", password='" + password + '\'' + '}';
    }
}
