package com.ms.service;

import com.ms.base.BaseTestClass;
import com.ms.pojo.User;
import com.ms.pojo.query.UserInviteQuery;
import org.junit.Test;

/**
 * Created by lenovo on 2019/1/4.
 */
public class UserServiceImplTest extends BaseTestClass {
    private IUserService service = (IUserService) getInstance("userService");

    public User getUser(){
        User user = new User();
        user.setOpenId("openid4");
        user.setThirdId("ThirdId4");
        user.setCommitStatus(1);
        user.setGameResult(0);
        user.setNickName("昵称");
        user.setHeadPic("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2411564211,2114787003&fm=173&app=25&f=JPEG?w=218&h=146&s=FEF23DC48E462F5754ECC8830300D0C3");
        return user;
    }

    @Test
    public void addUser(){
        System.out.println(service.addUser(getUser()));
    }

    @Test
    public void addUserBind(){
        System.out.println(service.addUser(getUser(), 3));
    }

    @Test
    public void getUserMethod(){
        System.out.println(service.getUser(3));
        System.out.println(service.getUserByThirdId("ThirdId"));
        System.out.println(service.getUserByOpenId("openId"));
    }

    @Test
    public void updateUserCommit(){
        System.out.println(service.updateUserCommit(7));
    }

    @Test
    public void finishGame(){
        System.out.println(service.finishGame(3));
    }

    @Test
    public void queryUserInvite(){
        UserInviteQuery query = new UserInviteQuery();
        query.setOpenId("openId4");
        System.out.println(service.queryUserInvite(query));
    }

    @Test
    public void inviteNum(){
        System.out.println(service.inviteNum(3,0));
    }
}
