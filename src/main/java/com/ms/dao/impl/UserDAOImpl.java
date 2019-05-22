package com.ms.dao.impl;

import com.ms.dao.BaseDAO;
import com.ms.dao.IUserDAO;
import com.ms.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019/1/4.
 */
@Repository("userDAO")
public class UserDAOImpl extends BaseDAO<User> implements IUserDAO {
    @Override
    public int saveUser(User user) {
        user.setcTime(new Date());
        user.setmTime(new Date());
        super.insert(user);
        return user.getUid();
    }

    @Override
    public User getUser(int userId) {
        return super.get(userId);
    }

    @Override
    public User getUserByThirdId(String thridId) {
        return super.findUniqueBy("selectByThird",thridId);
    }

    @Override
    public User getUserByOpenId(String openId) {
        return super.findUniqueBy("selectByOpenId",openId);
    }

    @Override
    public int updateCommitStatus(int uid, int commitStatus) {
        Map<String,Object> map = new HashMap<>();
        map.put("uid",uid);
        map.put("commitStatus",commitStatus);
        map.put("mTime",new Date());
        return super.updateBy("update_commit_status",map);
    }
}
