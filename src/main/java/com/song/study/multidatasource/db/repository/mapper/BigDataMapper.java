package com.song.study.multidatasource.db.repository.mapper;

import com.song.study.multidatasource.db.repository.mapper.provider.BigDataProvider;
import com.song.study.multidatasource.db.repository.po.BigDataPO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

/**
 * @author Cyrus
 * @version v1.0, 2017-09-15 17:47
 */
@Component
public interface BigDataMapper {

    @SelectProvider(type = BigDataProvider.class, method = "selectById")
    @Results(id = "Base_Result", value = {
            @Result(property = "id", column = "id", javaType = Long.class, jdbcType = JdbcType.BIGINT, id = true),
            @Result(property = "age", column = "age", javaType = Integer.class, jdbcType = JdbcType.INTEGER)})
    BigDataPO selectById(Long id);
}
