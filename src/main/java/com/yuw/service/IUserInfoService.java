package com.yuw.service;

import com.yuw.bean.UserInfoBean;

import java.util.List;

public interface IUserInfoService {
    /**
     * 登录查询：根据登录传入用户名密码进行登录查询操作
     *
     * @param userInfoBean 登录参数信息实体类
     * @return 查询结果集
     */
    public List<UserInfoBean> doLogin(UserInfoBean userInfoBean);
}
