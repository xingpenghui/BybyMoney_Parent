package com.feri.byby.mq.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *@Author feri
 *@Date Created in 2018/12/8 15:30
 */
public class Msg1Send {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1、创建连接工厂
        ConnectionFactory factory=new ConnectionFactory();
        //2、设置服务器信息
        factory.setHost("39.105.189.141");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        //3、获取连接对象
        Connection connection=factory.newConnection();
        //4、获取通道对象
        Channel channel=connection.createChannel();
        //5、创建存储对象   队列
        channel.queueDeclare("java1805",false,false,false,null);
        //6、发送消息
        channel.basicPublish("","java1805",null,("阶段考试，好嗨！："+System.currentTimeMillis()/1000).getBytes());
        //7、关闭
        channel.close();
        connection.close();
    }
}
