package com.song.study.multidatasource.db.repository;

import com.song.study.multidatasource.db.repository.po.BusinessPO;

/**
 * 业务数据
 *
 * @author Cyrus
 * @version v1.0, 2017-09-15 16:49
 */
public interface BusinessRepository {

    BusinessPO getById(Long id);
}
