package com.ms.pojo;

import java.util.Date;

/**
 * Created by lenovo on 2019/1/4.
 */
public class User {

    public final static   int GAMERESULT_NO = 0;

    public final static   int GAMERESULT_YES = 1;

    public final static   int COMMIT_NO = 0;

    public final static   int COMMIT_YES = 1;


    private int uid;

    //微信OpenId
    private String openId;

    //第三方用户id
    private String thirdId;

    private int gameResult;  //0 未完成  1 已完成

    private int commitStatus; //0 未成交 1 已成交

    private String nickName;

    //头像
    private String headPic;

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



    public int getGameResult() {
        return gameResult;
    }

    public void setGameResult(int gameResult) {
        this.gameResult = gameResult;
    }

    public int getCommitStatus() {
        return commitStatus;
    }

    public void setCommitStatus(int commitStatus) {
        this.commitStatus = commitStatus;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
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
        return "User{" +
                "uid=" + uid +
                ", openId='" + openId + '\'' +
                ", thirdId='" + thirdId + '\'' +
                ", gameResult=" + gameResult +
                ", commitStatus=" + commitStatus +
                ", nickName='" + nickName + '\'' +
                ", headPic='" + headPic + '\'' +
                ", cTime=" + cTime +
                ", mTime=" + mTime +
                '}';
    }
}
