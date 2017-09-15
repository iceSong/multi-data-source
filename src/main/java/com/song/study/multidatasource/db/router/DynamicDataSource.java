package com.song.study.multidatasource.db.router;

import com.google.common.collect.Lists;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.List;

/**
 * 实现数据源的选择方法
 *
 * @author Cyrus
 * @version v1.0, 2017-09-15 10:39
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    // 数据源类型集合
    private static final List<DataSourceType> dataSourceTypes = Lists.newArrayList();

    //线程本地环境
    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();

    //设置数据源
    public static void setDataSourceType(DataSourceType routingType) {
        contextHolder.set(routingType);
    }

    public static void addDataSourceType(DataSourceType dataSourceType) {
        if (dataSourceType != null) {
            dataSourceTypes.add(dataSourceType);
        }
    }

    public static void reset() {
        contextHolder.remove();
    }

    public static boolean containsDataSource(DataSourceType routingType) {
        return dataSourceTypes.contains(routingType);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return contextHolder.get();
    }
}
