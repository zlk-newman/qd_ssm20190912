package com.yuw.dao;

import com.yuw.bean.UserInfoBean;

import java.util.List;

public interface UserInfoBeanMapper {

    /**
     * 登录查询操作
     *
     * @param record 参数实体类
     * @return 查询结果集
     */
    List<UserInfoBean> doLogin(UserInfoBean record);

    int deleteByPrimaryKey(Integer userid);

    int insert(UserInfoBean record);

    int insertSelective(UserInfoBean record);

    UserInfoBean selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserInfoBean record);

    int updateByPrimaryKey(UserInfoBean record);
}