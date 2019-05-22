package com.ms.dao.impl;

import com.ms.dao.BaseDAO;
import com.ms.dao.IUserDetailDAO;
import com.ms.pojo.UserDetail;
import com.ms.pojo.query.UserDetailQuery;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by lenovo on 2019/5/22.
 */
@Repository("userDetailDAO")
public class UserDetailDAOImpl extends BaseDAO<UserDetail> implements IUserDetailDAO{

    @Override
    public int addUserDetail(UserDetail userDetail) {
        userDetail.setcTime(new Date());
        return super.insert(userDetail);
    }

    @Override
    public PageHolder<UserDetail> findList(UserDetailQuery query) {
        return super.pagedQuery("findByParams",query.getMap(),query.getPageIndex(),query.getPageSize());
    }
}
