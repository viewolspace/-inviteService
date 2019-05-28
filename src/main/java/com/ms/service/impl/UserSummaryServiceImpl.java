package com.ms.service.impl;

import com.ms.dao.IPrizeTimeDAO;
import com.ms.dao.IUserDAO;
import com.ms.dao.IUserDetailDAO;
import com.ms.dao.IUserSummaryDAO;
import com.ms.pojo.PrizeTime;
import com.ms.pojo.User;
import com.ms.pojo.UserDetail;
import com.ms.pojo.UserSummary;
import com.ms.pojo.query.UserDetailQuery;
import com.ms.service.IUserSummaryService;
import com.youguu.core.util.PageHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

/**
 * Created by lenovo on 2019/5/22.
 */
@Service("userSummaryService")
public class UserSummaryServiceImpl implements IUserSummaryService{

    private int max_prize = 10;

    @Resource
    private IUserDAO userDAO;

    @Resource
    private IUserSummaryDAO userSummaryDAO;

    @Resource
    private IPrizeTimeDAO prizeTimeDAO;

    @Resource
    private IUserDetailDAO userDetailDAO;

    @Override
    public int incTimes(int uid) {
        int result = 0;
        UserSummary userSummary = new UserSummary();
        User user =userDAO.getUser(uid);
        if(user!=null){
            userSummary.setUid(uid);
            userSummary.setVersion(0);
            userSummary.setAllTimes(1);
            userSummary.setUseTimes(0);
            userSummary.setTimes(1);
            result = userSummaryDAO.incTimes(userSummary);
        }

        return result;
    }

    @Override
    public UserSummary getUserSummary(int uid) {
        return userSummaryDAO.getUserSummary(uid);
    }

    /**
     *
     * @param uid
     * @return
     * -1 没有抽奖机会
     * 0  未中奖
     * 1  中奖了
     */
    @Transactional("msTX")
    @Override
    public int lottery(int uid) {
        //减少一次抽奖机会
        int result = userSummaryDAO.useTimes(uid);
        if(result == 0){
            return -1;
        }
        synchronized (this){
            PrizeTime p = prizeTimeDAO.getPrizeTime();
            if(p.getNum() > max_prize){ //没有奖品了
                result = 0 ;
            }else{
                if(p.getNextTime().before(new Date())){
                    //可能中奖
                    UserSummary userSummary = userSummaryDAO.getUserSummary(uid);
                    if(userSummary.getGrandPrize() == 0){
                        //1.修改下次中奖机会
                        Date nextDate = this.getNextDate(p);
                        prizeTimeDAO.updateNextTime(nextDate);
                        //2.修改用户的中奖属性
                        userSummaryDAO.updateGrandPrize(uid,1);
                        result = 1;
                    }else{//中过一次大奖的用户 不能中第二次
                        result = 0;
                    }

                }else{
                    result = 0;
                }
            }


        }
        //添加用户的中奖记录
        User user = userDAO.getUser(uid);
        UserDetail userDetail = new UserDetail();
        userDetail.setUid(uid);
        userDetail.setOpenId(user.getOpenId());
        userDetail.setThirdId(user.getThirdId());
        userDetail.setNickName(user.getNickName());
        userDetail.setPrize(result);
        userDetailDAO.addUserDetail(userDetail);
        return result;
    }


    @Override
    public PageHolder<UserDetail> queryUserDetail(UserDetailQuery query) {
        return userDetailDAO.findList(query);
    }

    /**
     *
     * @param prizeTime
     * @return
     */
    private Date getNextDate(PrizeTime prizeTime){

        long oneDay = 24 * 60 * 60 * 1000;

        Date start = prizeTime.getStartTime();

        Date now = new Date();

        int num = prizeTime.getNum() + 1; //第N个奖品

        long startTime =  (long)((num-1)*  2.5)*oneDay + start.getTime();

        long endTime =  (long)(num*  2.5)*oneDay + start.getTime();

        Random random = new Random();

        long nextTime = 0L;

        if(endTime < now.getTime()){ //参与活动的人数很少 ， 下次奖励的时间缩短为一天内
            int times = random.nextInt((int)(oneDay));
            nextTime = now.getTime() + times;
        }else{
            if(startTime > now.getTime()){
                int times = random.nextInt((int)(endTime-startTime));
                nextTime = startTime + times;
            }else{
                int times = random.nextInt((int)(endTime-now.getTime()));
                nextTime = now.getTime() + times;
            }
        }

        Date date = new Date(nextTime);

        return date;
    }
}
