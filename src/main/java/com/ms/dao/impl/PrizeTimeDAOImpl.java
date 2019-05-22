package com.ms.dao.impl;

import com.ms.dao.BaseDAO;
import com.ms.dao.IPrizeTimeDAO;
import com.ms.pojo.PrizeTime;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019/5/22.
 */
@Repository("prizeTimeDAO")
public class PrizeTimeDAOImpl extends BaseDAO<PrizeTime> implements IPrizeTimeDAO {
    @Override
    public PrizeTime getPrizeTime() {
        return super.findUniqueBy("selectOne",null);
    }


    @Override
    public int updateNextTime(Date date) {
        Map<String,Object> map = new HashMap<>();
        map.put("mTime",new Date());
        map.put("nextTime",date);
        return super.updateBy("updateNextTime",map);
    }
}
