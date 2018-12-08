package com.feri.byby.mq.test;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *@Author feri
 *@Date Created in 2018/12/8 15:51
 */
public class Msg2Send {
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
        //5、创建存储消息对象
        channel.exchangeDeclare("1805ex",BuiltinExchangeType.TOPIC);
        //6、发送消息
        for(int i=1;i<6;i++){
            /*
            * 参数说明：
            * 1、交换机名称
            * 2、路由名称
            * 3、额外参数
            * 4、发送的内容*/
            channel.basicPublish("1805ex","java05",null,("猪你快乐"+1).getBytes());
        }
    }
}
