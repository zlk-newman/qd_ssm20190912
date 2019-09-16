package com.yuw.service.impl;

import com.yuw.bean.UserInfoBean;
import com.yuw.dao.UserInfoBeanMapper;
import com.yuw.service.IUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoService implements IUserInfoService {

    // 依赖注入和反转控制
    @Resource
    private UserInfoBeanMapper userInfoM;

    @Override
    public List<UserInfoBean> doLogin(UserInfoBean userInfoBean) {
        // 调用Dao层进行数据库查询操作
        List<UserInfoBean> lstUserInfos = userInfoM.doLogin(userInfoBean);
        return lstUserInfos;
    }
}
