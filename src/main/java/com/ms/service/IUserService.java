package com.ms.service;

import com.ms.pojo.User;
import com.ms.pojo.UserInvite;
import com.ms.pojo.query.UserInviteQuery;
import com.youguu.core.util.PageHolder;

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

    /**
     * 完成游戏
     * @param uid
     * @return
     */
    int finishGame(int uid);


    PageHolder<UserInvite> queryUserInvite(UserInviteQuery query);

    /**
     * 邀请用户数
     * @param inviteUid
     * @return
     */
    int inviteNum(int inviteUid,int status);
}
