package com.ms.dao;

import com.ms.pojo.User;

/**
 * Created by lenovo on 2019/5/20.
 */
public interface IUserDAO {
    int saveUser(User user);

    User getUser(int userId);

    User getUserByThirdId(String thridId);

    User getUserByOpenId(String openId);

    int updateCommitStatus(int uid,int commitStatus);


    int updateGameResult(int uid,int gameResult);

}
