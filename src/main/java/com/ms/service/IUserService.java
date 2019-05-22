package com.ms.service;

import com.ms.pojo.User;

/**
 * Created by lenovo on 2019/5/20.
 */
public interface IUserService {

    /**
     * 普通添加用户
     * @param user
     * @return -1 用户已经存在
     */
    int addUser(User user);

    /**
     * 普通添加用户 ， 并绑定邀请关系
     * @param user
     * @param inviteUid
     * @return -1 用户已存在
     */
    int addUser(User user,int inviteUid);

    User getUser(int userId);

    User getUserByThirdId(String thridId);

    User getUserByOpenId(String openId);

    /**
     * 修改成交状态
     * 没有邀请的用户直接修改
     * 如果当前用户被邀请了，需要分配抽奖机会
     * @param uid
     * @return
     */
    int updateUserCommit(int uid);


}
