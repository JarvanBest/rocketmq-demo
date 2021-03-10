package com.shuhai.rocketmq.demo.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.SubscribableChannel;


@EnableBinding({ Source.class, RocketMqConfig.MySink.class })
public class RocketMqConfig {
    public interface MySink {
        @Input(Sink.INPUT)
        SubscribableChannel input();

        @Input("inputDlq")
        SubscribableChannel inputDlq();
    }
}
