package com.ms.service.impl;

import com.ms.dao.IUserDAO;
import com.ms.dao.IUserInviteDAO;
import com.ms.exception.BaseException;
import com.ms.pojo.User;
import com.ms.pojo.UserInvite;
import com.ms.pojo.query.UserInviteQuery;
import com.ms.service.IUserService;
import com.ms.service.IUserSummaryService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2019/5/20.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDAO userDAO;

    @Resource
    private IUserInviteDAO userInviteDAO;

    @Resource
    private IUserSummaryService userSummaryService;


    @Override
    public int addUser(User user) {
        User user1 = userDAO.getUserByOpenId(user.getOpenId());
        if(user1!=null){
            return -1;
        }
        return userDAO.saveUser(user);
    }

    @Transactional("msTX")
    @Override
    public int addUser(User user, int inviteUid) {
        //查询用户是否已存在
        User user1 = userDAO.getUserByOpenId(user.getOpenId());
        if(user1!=null){
            return -1;
        }
        //添加用户
        int uid = userDAO.saveUser(user);

        if(uid == 0){
            return 0;
        }


        User inviteUser = userDAO.getUser(inviteUid);

        //已经成交的用户 都是老用户 不记录绑定关系
        if(inviteUser!=null && user.getCommitStatus()==User.COMMIT_NO && inviteUser.getCommitStatus()==User.COMMIT_YES){
            //绑定关系
            UserInvite userInvite = new UserInvite();
            userInvite.setUid(uid);
            userInvite.setOpenId(user.getOpenId());
            userInvite.setThirdId(user.getThirdId());
            userInvite.setNickName(user.getNickName());
            userInvite.setInviteUid(inviteUid);
            userInvite.setInviteNickName(inviteUser.getNickName());
            userInvite.setInviteOpenId(inviteUser.getOpenId());
            userInvite.setInviteThirdId(inviteUser.getThirdId());
            userInvite.setStatus(User.COMMIT_NO);
            int result = userInviteDAO.addUserInvite(userInvite);
            if (result<=0){
                throw new BaseException("0001","插入邀请关系失败");
            }
        }

        return 1;
    }

    @Override
    public User getUser(int userId) {
        return userDAO.getUser(userId);
    }

    @Override
    public User getUserByThirdId(String thridId) {
        return userDAO.getUserByThirdId(thridId);
    }

    @Override
    public User getUserByOpenId(String openId) {
        return userDAO.getUserByOpenId(openId);
    }

    @Transactional("msTX")
    @Override
    public int updateUserCommit(int uid) {
        int result = 0;
        //判断当前用户的状态
        User user = userDAO.getUser(uid);
        if(user.getCommitStatus() == User.COMMIT_YES){
            //已经是成交状态的用户忽略
            return result;
        }
        //判断当前用户是否是被邀请的用户
        UserInvite userInvite = userInviteDAO.getUserInvite(uid);
        if(userInvite==null){//直接修改自己的就可以
            result = userDAO.updateCommitStatus(uid,User.COMMIT_YES);
        }else{
            if(userInvite.getStatus()!=User.COMMIT_YES){
                result = userInviteDAO.updateStatus(uid,User.COMMIT_YES);
                if(result > 0){ //防止重复修改
                    result = userDAO.updateCommitStatus(uid,User.COMMIT_YES);
                    if(result > 0){ //防止重复修改
                        //增加抽奖机会
                        userSummaryService.incTimes(userInvite.getUid());
                        userSummaryService.incTimes(userInvite.getInviteUid());
                        result = 2;
                    }
                }
            }

        }


        return result;
    }

    @Override
    public int finishGame(int uid) {
        return userDAO.updateGameResult(uid,User.GAMERESULT_YES);
    }

    @Override
    public PageHolder<UserInvite> queryUserInvite(UserInviteQuery query) {
        return userInviteDAO.findList(query);
    }

    /**
     * 状态目前先没用
     * @param inviteUid
     * @param status
     * @return
     */
    @Override
    public int inviteNum(int inviteUid, int status) {
        return userInviteDAO.inviteNum(inviteUid, status);
    }
}
