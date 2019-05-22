package com.ms.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2019/5/21.
 */
public class UserSummary {

    private int uid;
    private int times;
    private int useTimes;
    private int allTimes;
    private int grandPrize; // 0 未中奖  1 中奖
    private Date cTime;
    private Date mTime;
    private int version;


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(int useTimes) {
        this.useTimes = useTimes;
    }

    public int getAllTimes() {
        return allTimes;
    }

    public void setAllTimes(int allTimes) {
        this.allTimes = allTimes;
    }

    public int getGrandPrize() {
        return grandPrize;
    }

    public void setGrandPrize(int grandPrize) {
        this.grandPrize = grandPrize;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    @Override
    public String toString() {
        return "UserSummary{" +
                "uid=" + uid +
                ", times=" + times +
                ", useTimes=" + useTimes +
                ", allTimes=" + allTimes +
                ", grandPrize=" + grandPrize +
                ", cTime=" + cTime +
                ", mTime=" + mTime +
                ", version=" + version +
                '}';
    }
}
