package com.ms.dao.impl;

import com.ms.dao.BaseDAO;
import com.ms.dao.IUserInviteDAO;
import com.ms.pojo.UserInvite;
import com.ms.pojo.query.UserInviteQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019/5/21.
 */
@Repository("userInviteDAO")
public class UserInviteDAOImpl extends BaseDAO<UserInvite> implements IUserInviteDAO{


    @Override
    public int addUserInvite(UserInvite userInvite) {
        Date date = new Date();
        userInvite.setcTime(date);
        userInvite.setmTime(date);
        return super.insert(userInvite);
    }

    @Override
    public UserInvite getUserInvite(int uid) {
        return super.get(uid);
    }

    @Override
    public int updateStatus(int uid, int status) {

        Map<String,Object> map = new HashMap<>();
        map.put("uid",uid);
        map.put("status",status);
        return super.updateBy("update_status",map);
    }

    @Override
    public int inviteNum(int inviteUid, int status) {
        Map<String,Object> map = new HashMap<>();
        map.put("inviteUid",inviteUid);
        map.put("status",status);
        return super.count("selectCount",inviteUid);
    }

    @Override
    public PageHolder<UserInvite> findList(UserInviteQuery query) {
        return super.pagedQuery("findByParams",query.getMap(),query.getPageIndex(),query.getPageSize());
    }
}
