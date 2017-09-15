package com.song.study.multidatasource;

import com.song.study.multidatasource.config.DynamicDataSourceConfig;
import com.song.study.multidatasource.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * 启动类
 *
 * @author Cyrus
 * @version v1.0, 2017-09-14 17:35
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({DynamicDataSourceConfig.class})
@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private SampleService sampleService;

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(sampleService.getBigData(1L));
        System.out.println(sampleService.getBusiness(1L));
    }
}
