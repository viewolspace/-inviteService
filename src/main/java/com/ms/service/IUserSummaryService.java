package com.ms.service;

import com.ms.pojo.UserDetail;
import com.ms.pojo.UserSummary;
import com.ms.pojo.query.UserDetailQuery;
import com.youguu.core.util.PageHolder;

/**
 * Created by lenovo on 2019/5/22.
 */
public interface IUserSummaryService {
    /**
     * 增加抽奖机会
     * 内部使用
     * @param uid
     * @return
     */
    int incTimes(int uid);

    /**
     * 获取用户当前1的概况
     * @param uid
     * @return
     */
    UserSummary getUserSummary(int uid);

    /**
     * 用户抽奖
     * @param uid
     * @return
     */
    int lottery(int uid);


    PageHolder<UserDetail> queryUserDetail(UserDetailQuery query);
}
