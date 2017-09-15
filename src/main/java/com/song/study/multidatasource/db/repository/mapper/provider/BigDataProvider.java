package com.song.study.multidatasource.db.repository.mapper.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author Cyrus
 * @version v1.0, 2017-09-15 17:51
 */
public class BigDataProvider {

    private static final String ALL_FIELDS = "id, age";
    private static final String TABLE = "t_age";

    public String selectById(Long id) {
        SQL sql = new SQL().SELECT(ALL_FIELDS).FROM(TABLE).WHERE("id = " + id + "");
        return sql.toString();
    }
}
