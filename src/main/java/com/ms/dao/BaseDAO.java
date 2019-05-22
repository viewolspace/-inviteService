package com.ms.dao;

import com.youguu.core.dao.SqlDAO;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2018/6/27.
 */
public class BaseDAO<T> extends SqlDAO<T> {
    public BaseDAO() {
        super();
        setUseSimpleName(true);
    }

    @Resource(name = "msSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
