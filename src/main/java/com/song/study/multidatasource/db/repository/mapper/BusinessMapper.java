package com.song.study.multidatasource.db.repository.mapper;

import com.song.study.multidatasource.db.repository.mapper.provider.BusinessProvider;
import com.song.study.multidatasource.db.repository.po.BusinessPO;
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
public interface BusinessMapper {

    @SelectProvider(type = BusinessProvider.class, method = "selectById")
    @Results(id = "Base_Result", value = {
            @Result(property = "id", column = "id", javaType = Long.class, jdbcType = JdbcType.BIGINT, id = true),
            @Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    BusinessPO selectById(Long id);
}
