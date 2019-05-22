package com.ms.dao;

import com.ms.pojo.UserDetail;
import com.ms.pojo.query.UserDetailQuery;
import com.youguu.core.util.PageHolder;

/**
 * Created by lenovo on 2019/5/22.
 */
public interface IUserDetailDAO {

    int addUserDetail(UserDetail userDetail);

    PageHolder<UserDetail> findList(UserDetailQuery query);

}
