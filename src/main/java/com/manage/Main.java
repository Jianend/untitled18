package com.manage;

import com.manage.entlty.Student;
import com.manage.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory factory =new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        SqlSession sqlSession = factory.openSession(true);
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        mapper.addStudent(new Student("Ð¡Ã÷","ÄÐ",2019));

    }
}
