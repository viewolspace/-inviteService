package com.ms.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2019/5/20.
 */
public class UserInvite {
    private int uid;

    private String thirdId;

    private String openId;

    private String nickName;

    private int inviteUid;

    private String inviteThirdId;

    private String inviteOpenId;

    private String inviteNickName;

    private int status;  //0未成交 没有抽奖机会   //1.已成交 并且分配了抽奖机会

    private Date cTime;

    private Date mTime;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getInviteUid() {
        return inviteUid;
    }

    public void setInviteUid(int inviteUid) {
        this.inviteUid = inviteUid;
    }

    public String getInviteThirdId() {
        return inviteThirdId;
    }

    public void setInviteThirdId(String inviteThirdId) {
        this.inviteThirdId = inviteThirdId;
    }

    public String getInviteOpenId() {
        return inviteOpenId;
    }

    public void setInviteOpenId(String inviteOpenId) {
        this.inviteOpenId = inviteOpenId;
    }

    public String getInviteNickName() {
        return inviteNickName;
    }

    public void setInviteNickName(String inviteNickName) {
        this.inviteNickName = inviteNickName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "UserInvite{" +
                "uid=" + uid +
                ", thirdId='" + thirdId + '\'' +
                ", openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", inviteUid=" + inviteUid +
                ", inviteThirdId='" + inviteThirdId + '\'' +
                ", inviteOpenId='" + inviteOpenId + '\'' +
                ", inviteNickName='" + inviteNickName + '\'' +
                ", status=" + status +
                ", cTime=" + cTime +
                ", mTime=" + mTime +
                '}';
    }
}
