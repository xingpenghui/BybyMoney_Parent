package com.feri.byby.common.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * @author xing
 */
public class HttpUtils {
	//基于HttpURLConnection
	public static String getLocation(String ip) {
		BufferedReader reader=null;
		HttpURLConnection huc=null;
		try {
			//创建请求的路径对象
			URL url=new URL(ip);
			//获取连接对象
			huc=(HttpURLConnection) url.openConnection();
			//连接
			huc.connect();
			//验证状态响应码
			if(huc.getResponseCode()==200) {
				//从响应字节流中获取内容
				StringBuffer buffer=new StringBuffer();
				reader=new BufferedReader(new InputStreamReader(huc.getInputStream(),"UTF-8"));
				String msg=null;
				while ((msg=reader.readLine())!=null) {
					buffer.append(msg);
				}
				
				return buffer.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			huc.disconnect();
		}
		return null;
	}
	public static String pullData(String url){
		HttpClient client= HttpClientBuilder.create().build();
		return null;
	}

	//获取网络信息 字符串
	public static String getString(String method,String url, Map<String,String> params){
		String res="";
		try {
			switch (method){
				case "GET"://get请求
					res=get(url,params);
					break;
				case "POST"://post请求
					res=post(url, params);
					break;
			}
		}catch (IOException e){

		}
		return res;
	}
	//获取网络信息 字符串
	public static byte[] getResource(String url) throws IOException {
		//1、创建请求方式
		HttpGet httpGet=new HttpGet(url);
		//2、设置请求信息
		//httpGet.setHeader();
		//3、创建客户端
		HttpClient client=HttpClientBuilder.create().build();
		//4、发起请求
		HttpEntity httpEntity=client.execute(httpGet).getEntity();
		//5、转换响应内容为字节数组
		byte[] arr=IOUtils.toByteArray(httpEntity.getContent());
		return arr;
	}

	private static String get(String url, Map<String,String> params) throws IOException {
		//1、拼接请求参数
		StringBuffer buffer=new StringBuffer();
		if(params!=null) {
			for (String p : params.keySet()) {
				buffer.append(p + "=" + params.get(p) + "&");
			}
			if (buffer.length() > 0) {
				buffer.deleteCharAt(buffer.length() - 1);
			}
			url=url+"?"+buffer.toString();
		}
		//2、创建请求方式
		HttpGet httpGet=new HttpGet(url);
		//3、设置请求信息
		//httpGet.setHeader();
		//4、创建客户端
		HttpClient client=HttpClientBuilder.create().build();
		//5、发起请求
		HttpEntity httpEntity=client.execute(httpGet).getEntity();
		//6、解析响应结果
		//传统IO读取
//		InputStream inputStream=httpEntity.getContent();
//		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
//		StringBuffer res=new StringBuffer();
//		String data=null;
//		while ((data=bufferedReader.readLine())!=null){
//			res.append(data);
//		}
//		bufferedReader.close();
//		inputStream.close();
//		return res.toString();
		return EntityUtils.toString(httpEntity,"UTF-8");
	}
	private static String post(String url, Map<String,String> params) throws IOException {
		//1、创建请求方式
		HttpPost httpPost=new HttpPost(url);
		//2、创建请求参数信息
		//键值对模式
		if(params!=null) {
			List<NameValuePair> pairs = new ArrayList<>();
			for (String p : params.keySet()) {
				pairs.add(new BasicNameValuePair(p, params.get(p)));
			}
			UrlEncodedFormEntity entityList = new UrlEncodedFormEntity(pairs);
			//StringEntity entity=new StringEntity()//支持json
			httpPost.setEntity(entityList);
		}
		//3、设置消息头
		//4、创建客户端
		HttpClient client=HttpClientBuilder.create().build();
		//5、执行请求
		HttpEntity httpEntity=client.execute(httpPost).getEntity();
		return EntityUtils.toString(httpEntity,"UTF-8");
	}
}