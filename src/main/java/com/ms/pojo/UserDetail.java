package com.ms.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2019/5/22.
 */
public class UserDetail {
    private int id ;
    private String openId;
    private String thirdId;
    private String nickName;
    private int uid;
    private Date cTime;
    private int prize;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }


    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                ", thirdId='" + thirdId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", uid=" + uid +
                ", cTime=" + cTime +
                ", prize=" + prize +
                '}';
    }
}
