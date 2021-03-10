package com.shuhai.rocketmq.demo.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

/**
 * 配置消息生产者
 */
@EnableBinding({RocketMqConfig.MySource.class})
public class RocketMqConfig {
    public interface MySource {
        @Output(Source.OUTPUT)
        MessageChannel output();
    }
}
