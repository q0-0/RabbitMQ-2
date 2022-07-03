package com.fy.rabbitmq2.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　 ┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　  ┃
 * 　　┃　　　　　　 ┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　 ┃
 * 　　┗━┓　　　┏━┛Faith and purpose must always be in the heart of the programmer
 * 　　　　┃　　　┃
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 *
 * @Author: fly
 * @Description:
 */

@SpringBootTest
public class DeadTest {
    @Autowired
    private RabbitTemplate template;

    @Test
    public void t1(){
        //消息发送给队列1
        template.convertAndSend("","fy-q1","HelloWord");
        System.out.println("发送消息："+ System.currentTimeMillis());
    }

}
