package com.song.study.multidatasource.db.repository.impl;

import com.song.study.multidatasource.db.repository.BusinessRepository;
import com.song.study.multidatasource.db.repository.mapper.BusinessMapper;
import com.song.study.multidatasource.db.repository.po.BusinessPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Cyrus
 * @version v1.0, 2017-09-15 16:55
 */
@Service
public class BusinessRepositoryImpl implements BusinessRepository {
    @Autowired
    private BusinessMapper businessMapper;
    @Override
    public BusinessPO getById(Long id) {
        return businessMapper.selectById(id);
    }
}
