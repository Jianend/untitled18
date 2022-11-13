package com.manage;

import com.manage.Utils.MyBatisUtils;
import com.manage.Utils.Utility;
import com.manage.entlty.Student;
import com.manage.entlty.book;
import com.manage.entlty.borrow;
import com.manage.mapper.BookMapper;
import lombok.extern.java.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;

@Log
public class Main {

    static SqlSession sqlSession = MyBatisUtils.getSqlSession();
    static BookMapper mapper = sqlSession.getMapper(BookMapper.class);
    public static void main(String[] args) throws IOException {
        boolean fool=true;
        LogManager logManager = LogManager.getLogManager();
        logManager.readConfiguration(Resources.getResourceAsStream("logging.properties"));
        while (fool) {
            System.out.println("=======================");
            System.out.println("\t 1\t 录入学生信息");
            System.out.println("\t 2\t 录入书籍");
            System.out.println("\t 3\t 借书");
            System.out.println("\t 4\t 借阅查询");
            System.out.println("=======================");
            int i = Utility.readInt(1);
            switch (i){
                case 1:
                    student();
                    break;
                case 2:
                    book();
                    break;
                case 3:
                    addBorrow();
                    break;
                case 4:
                    showBorrow();
                    break;

                default:
                    fool=false;


            }
        }


    }

    private  static  void  showBorrow(){
        System.out.println("===========");
        System.out.println("以借阅的书籍");
        List<borrow> getborrow = mapper.getborrow();//借阅关系
        for (borrow borrow : getborrow) {
            int bid = borrow.getBid();
            book getbook = mapper.getbook(bid);
            System.out.println(getbook);
            int sid = borrow.getSid();
            Student getstudent = mapper.getstudent(sid);
            System.out.print("借阅人：");
            System.out.println(getstudent);
        }


        System.out.println("===========");

    }

    private  static void addBorrow(){
        System.out.println("请输入书籍号");
        String s = Utility.readString(4);
        int bid = Integer.parseInt(s);
        System.out.println("请输入学号");
        int sid = Utility.readInt();
        mapper.addborrow(sid,bid);

    }
  public static void   student(){
      System.out.print("输入姓名：");
      String m = Utility.readString(10);
      System.out.println("输入性别");
      String s = Utility.readString(2);
      System.out.println("时间");
      int y = Utility.readInt();
      Student student = new Student(m,s,y);
      int i = mapper.addStudent(student);
      if (i>0){
          log.info("新添加一条学生信息："+student);
      }else {
          log.info("插入学生失败");
      }
  }
  public  static void  book(){
      System.out.print("书籍名称:");
      String m = Utility.readString(10);
      System.out.print("书籍备注:");
      String s = Utility.readString(1);
      System.out.print("价钱:");
      int j = Utility.readInt();
      book book = new book(m, s, j);
      int addbook = mapper.addbook(book);
      if (addbook>0){
          log.info("新添加一条书籍"+book);
      }else {
          log.info("插入书籍失败");
      }

  }
}
