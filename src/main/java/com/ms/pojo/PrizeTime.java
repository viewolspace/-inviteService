package com.ms.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2019/5/22.
 * 奖池规则
 * 2.5 天一个 前10天最多4个1
 *           后十天 3个
 *          最后十天 3个
 */
public class PrizeTime {

    private int num;        //第几次大奖

    private Date startTime;  //活动开始时间

    private Date nextTime;  //下次中奖时间

    private Date mTime;    //修改时间

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getNextTime() {
        return nextTime;
    }

    public void setNextTime(Date nextTime) {
        this.nextTime = nextTime;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    @Override
    public String toString() {
        return "PrizeTime{" +
                "num=" + num +
                ", startTime=" + startTime +
                ", nextTime=" + nextTime +
                ", mTime=" + mTime +
                '}';
    }
}
