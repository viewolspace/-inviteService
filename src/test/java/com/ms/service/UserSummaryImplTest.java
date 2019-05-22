package com.ms.service;

import com.ms.base.BaseTestClass;
import com.ms.pojo.query.UserDetailQuery;
import org.junit.Test;

/**
 * Created by lenovo on 2019/1/4.
 */
public class UserSummaryImplTest extends BaseTestClass {
    private IUserSummaryService service = (IUserSummaryService) getInstance("userSummaryService");


    @Test
    public void getUserSummary(){
        System.out.println(service.getUserSummary(3));
    }

    @Test
    public void lottery(){
        System.out.println(service.lottery(3));
    }

    @Test
    public void queryUserDetail(){
        UserDetailQuery query = new UserDetailQuery();
        query.setOpenId("openId");
        System.out.println(service.queryUserDetail(query));
    }

}
