package com.shuhai.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 描述：
 *
 * @author 含光
 * @email jarvan_best@163.com
 * @date 2021/3/10 10:54 上午
 * @company 数海掌讯
 */
@SpringBootApplication
@EnableTransactionManagement
public class RocketMqTxApp {
    public static void main(String[] args) {
        SpringApplication.run(RocketMqTxApp.class, args);
    }
}
