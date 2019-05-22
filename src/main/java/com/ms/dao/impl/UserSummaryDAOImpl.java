package com.ms.dao.impl;

import com.ms.dao.BaseDAO;
import com.ms.dao.IUserSummaryDAO;
import com.ms.pojo.UserSummary;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019/5/21.
 */
@Repository("userSummaryDAO")
public class UserSummaryDAOImpl  extends BaseDAO<UserSummary> implements IUserSummaryDAO{
    @Override
    public int incTimes(UserSummary userSummary) {
        return super.insert(userSummary);
    }

    @Override
    public UserSummary getUserSummary(int uid) {
        return super.get(uid);
    }

    @Override
    public int useTimes(int uid) {
        Map<String,Object> map = new HashMap<>();
        map.put("uid",uid);
        map.put("mTime",new Date());
        return super.updateBy("useTimes",map);
    }
}
