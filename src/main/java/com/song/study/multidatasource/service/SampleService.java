package com.song.study.multidatasource.service;

import com.song.study.multidatasource.db.repository.po.BigDataPO;
import com.song.study.multidatasource.db.repository.po.BusinessPO;

/**
 * @author Cyrus
 * @version v1.0, 2017-09-15 17:18
 */
public interface SampleService {

    BusinessPO getBusiness(Long id);

    BigDataPO getBigData(Long id);
}
