package com.manage.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //ʹ��Mybatis��һ������ȡsqlSessionFactory����
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //��Ȼ���� SqlSessionFactory������˼�壬���ǾͿ��Դ��л�� SqlSession ��ʵ���ˡ�SqlSession ��ȫ�������������ݿ�ִ�� SQL
    // ������������з����������ͨ�� SqlSession ʵ����ֱ��ִ����ӳ��� SQL ���

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);  //��������Ϊtrue,Ĭ���ύ����

    }
}
