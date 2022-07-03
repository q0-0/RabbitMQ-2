package com.fy.rabbitmq2.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

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
 * @Description: 基于RabbitMQ实现延迟队列(推荐): 双队列+交换器+死信机制 实现延迟处理
 *   RabbitMQ实现延迟消息代码
 */

@Configuration
public class RabbitMQConfig {
    //1 创建队列
    // 创建第一个队列：1 设置有效期 2 设置死信交换器
    @Bean
    public Queue create1(){
        // 1 实例化 集合 设置 队列的参数信息
        HashMap<String, Object> params = new HashMap<>();
        //设置消息有效期 单位是毫秒
        params.put("x-message-ttl",10000); //参数1固定；自定义：10秒
        //设置死信交换器名称 一旦队列中有死信，就会自动发送给死信交换器 交换器类型：direct（精准路由）
        params.put("x-dead-letter-exchange","dead-ex");//参数1固定；参数2：自定义值
        //设置 死信交换器的路由关键字
        params.put("x-dead-letter-routing-key","fy-test");//参数1固定
        //2 创建队列
        return QueueBuilder.durable("fy-q1").withArguments(params).build();
    }

    //创建第二个队列
    @Bean
    public Queue create2(){
        return new Queue("fy-q2");
    }

    //2 创建死信交换器
    @Bean
    public DirectExchange createEx1(){
        return new DirectExchange("dead-ex");//与上面保持一致
    }

    //3 创建交换器和队列之间绑定
    @Bean
    public Binding createBd1(DirectExchange de){
        return BindingBuilder.bind(create2()).to(de).with("fy-test");//与上面保持一致
    }
}
