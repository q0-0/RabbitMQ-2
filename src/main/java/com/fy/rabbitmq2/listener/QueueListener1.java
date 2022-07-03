package com.fy.rabbitmq2.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

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

@Component
@RabbitListener(queues = "fy-q2")  //监听队列2
public class QueueListener1 {
    @RabbitHandler
    public void  t1(String msg){
        System.out.println("延迟消息："+ msg+"--->" + System.currentTimeMillis());
    }
}
