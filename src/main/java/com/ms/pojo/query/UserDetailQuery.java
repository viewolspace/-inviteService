package com.ms.pojo.query;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019/5/22.
 */
public class UserDetailQuery {
    private Integer uid;
    private String openId;
    private String thirdId;
    private Integer prize;
    private String nickName;

    private int pageIndex=1;
    private int pageSize=20;

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

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public Integer getPrize() {
        return prize;
    }

    public void setPrize(Integer prize) {
        this.prize = prize;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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


    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<>();
        if(uid!=null){
            map.put("uid",uid);
        }
        if(openId!=null){
            map.put("openId",openId);
        }
        if(nickName!=null){
            map.put("nickName",nickName);
        }

        if(thirdId!=null){
            map.put("thirdId",thirdId);
        }
        if(prize!=null){
            map.put("prize",prize);
        }
        return map;
    }
}
