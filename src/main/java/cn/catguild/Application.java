package cn.catguild;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 主启动类
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild
 * @description
 * @date Created in 2020-09-08 00:35
 * @copyright Copyright (c) 2020
 * @modified zhi.liu
 */
@SpringBootApplication(scanBasePackages = {"cn.catguild","cn.hutool.extra.spring"})
@EnableReactiveMongoRepositories
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
