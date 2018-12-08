package com.feri.byby.mq.test;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *@Author feri
 *@Date Created in 2018/12/8 15:42
 */
public class Msg1Receive {
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
        //5、指定存储消息的对象
        channel.queueDeclare("java1805",false,false,false,null);
        //6、消息消费
        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者获取消息："+new String(body));
            }
        };
        //7、设置应答
        channel.basicConsume("java1805",true,consumer);

        //8、关闭
//        channel.close();
//        connection.close();
    }
}
