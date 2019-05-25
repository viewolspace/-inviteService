package com.ms.pojo.query;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019/5/21.
 */
public class UserInviteQuery {
    private Integer uid;

    private String openId;

    private String nickName;

    private String inviteOpenId;

    private String inviteNickName;

    private int pageIndex = 1;

    private int pageSize = 20;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>();
        if (uid != null && uid > 0) {
            map.put("uid", uid);
        }
        if (openId != null) {
            map.put("openId", openId);
        }
        if (nickName != null) {
            map.put("nickName", nickName);
        }

        if (inviteOpenId != null) {
            map.put("inviteOpenId", inviteOpenId);
        }
        if (inviteNickName != null) {
            map.put("inviteNickName", inviteNickName);
        }
        return map;
    }
}
