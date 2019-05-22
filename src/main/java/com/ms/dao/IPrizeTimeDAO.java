package com.ms.dao;

import com.ms.pojo.PrizeTime;

import java.util.Date;

/**
 * Created by lenovo on 2019/5/22.
 */
public interface IPrizeTimeDAO {

    PrizeTime getPrizeTime();

    int updateNextTime(Date date);

}
