package com.ms.dao;

import com.ms.pojo.UserInvite;
import com.ms.pojo.query.UserInviteQuery;
import com.youguu.core.util.PageHolder;

/**
 * Created by lenovo on 2019/5/21.
 */
public interface IUserInviteDAO {

    int addUserInvite(UserInvite userInvite);

    UserInvite getUserInvite(int uid);

    int updateStatus(int uid,int status);

    int inviteNum(int inviteUid,int status);

    PageHolder<UserInvite> findList(UserInviteQuery query);
}
