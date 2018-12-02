package com.feri.byby.es.test;
import com.feri.byby.es.dao.JavaProjectDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *@Author feri
 *@Date Created in 2018/12/2 17:13
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-*.xml");
        JavaProjectDao dao=context.getBean(JavaProjectDao.class);
        System.out.println(dao);
    }
}