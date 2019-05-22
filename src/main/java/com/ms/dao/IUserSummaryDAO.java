package com.ms.dao;

import com.ms.pojo.UserSummary;

/**
 * Created by lenovo on 2019/5/21.
 */
public interface IUserSummaryDAO {

    int incTimes(UserSummary userSummary);


    UserSummary getUserSummary(int uid);

    /**
     * 使用一次抽奖机会
     * @param uid
     * @return
     */
    int useTimes(int uid);

}
