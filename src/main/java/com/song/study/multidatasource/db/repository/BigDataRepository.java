package com.song.study.multidatasource.db.repository;

import com.song.study.multidatasource.db.repository.po.BigDataPO;

/**
 * 大数据数据
 *
 * @author Cyrus
 * @version v1.0, 2017-09-15 16:50
 */
public interface BigDataRepository {

    BigDataPO getById(Long id);
}
