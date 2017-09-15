package com.song.study.multidatasource.service.impl;

import com.song.study.multidatasource.db.repository.BigDataRepository;
import com.song.study.multidatasource.db.repository.BusinessRepository;
import com.song.study.multidatasource.db.repository.po.BigDataPO;
import com.song.study.multidatasource.db.repository.po.BusinessPO;
import com.song.study.multidatasource.db.router.DataSourceType;
import com.song.study.multidatasource.db.router.TargetDataSource;
import com.song.study.multidatasource.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Cyrus
 * @version v1.0, 2017-09-15 17:22
 */
@Service
public class SampleServiceImpl implements SampleService {
    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private BigDataRepository bigDataRepository;

    @Override
    @TargetDataSource(type = DataSourceType.Business)
    public BusinessPO getBusiness(Long id) {
        return businessRepository.getById(id);
    }

    @Override
    @TargetDataSource(type = DataSourceType.BigData)
    public BigDataPO getBigData(Long id) {
        return bigDataRepository.getById(id);
    }
}
