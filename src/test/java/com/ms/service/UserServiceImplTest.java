package com.ms.service;

import com.ms.base.BaseTestClass;
import com.ms.pojo.User;
import org.junit.Test;

/**
 * Created by lenovo on 2019/1/4.
 */
public class UserServiceImplTest extends BaseTestClass {
    private IUserService service = (IUserService) getInstance("userService");

    public User getUser(){
        User user = new User();
        user.setOpenId("openid");
        user.setThirdId("ThirdId");
        user.setCommitStatus(2);
        user.setGameResult(0);
        user.setNickName("昵称");
        user.setHeadPic("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2411564211,2114787003&fm=173&app=25&f=JPEG?w=218&h=146&s=FEF23DC48E462F5754ECC8830300D0C3");
        return user;
    }

    @Test
    public void addUser(){
        System.out.println(service.addUser(getUser()));
    }


}
