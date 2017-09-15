package com.song.study.multidatasource.db.repository.impl;

import com.song.study.multidatasource.db.repository.BigDataRepository;
import com.song.study.multidatasource.db.repository.mapper.BigDataMapper;
import com.song.study.multidatasource.db.repository.po.BigDataPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Cyrus
 * @version v1.0, 2017-09-15 16:55
 */
@Service
public class BigDataRepositoryImpl implements BigDataRepository {
@Autowired
private BigDataMapper bigDataMapper;
    @Override
    public BigDataPO getById(Long id) {
        return bigDataMapper.selectById(id);
    }
}
