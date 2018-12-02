package com.feri.byby.es.app;

import com.alibaba.fastjson.JSON;
import com.feri.byby.domain.user.User;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.Transport;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetSocketAddress;

/**
 *@Author feri
 *@Date Created in 2018/12/2 15:41
 */
public class Transport_Main {
    public static void main(String[] args){

        //1、创建配置对象 指定集群名称
        Settings settings=Settings.builder().put("cluster.name","es01").build();
        //2、创建客户端对象
        Client client=new PreBuiltTransportClient(settings).
                addTransportAddress(
                new TransportAddress(
                new InetSocketAddress("10.8.162.28",9300)));
        //3、操作es服务器  CRUD

        //新增
        User user=new User();
        user.setPhone("666");
        user.setPassword("qfjava");
        user.setNickname("zz1805");
        user.setId(1);
//        IndexResponse response=client.
//                prepareIndex("users","user",user.getId()+"").//设置索引信息 第一个参数：索引名称 第二个参数：存储内容的类型 第三个参数：存储内容的序号
//                setSource(JSON.toJSONString(user),XContentType.JSON).//设置要存储的内容：第一个参数 存储的的内容 第二个参数：存储的格式
//                get();
//        System.out.println("新增："+response.status().toString());

        //修改
//        UpdateResponse updateResponse=client.prepareUpdate("users","user","1").
//                setDoc(JSON.toJSONString(user),XContentType.JSON).get();
//        System.out.println("修改："+updateResponse.status().toString());
//
        //删除
        DeleteResponse deleteResponse=client.prepareDelete("users","user","1").get();
        System.out.println("删除："+deleteResponse.status().toString());
        //查询
        GetResponse getResponse=client.prepareGet("users","user","1").get();
        System.out.println("查询："+getResponse.getSourceAsString());


    }
}
