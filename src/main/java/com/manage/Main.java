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
            System.out.println("\t 1\t ¼��ѧ����Ϣ");
            System.out.println("\t 2\t ¼���鼮");
            System.out.println("\t 3\t ����");
            System.out.println("\t 4\t ���Ĳ�ѯ");
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
        System.out.println("�Խ��ĵ��鼮");
        List<borrow> getborrow = mapper.getborrow();//���Ĺ�ϵ
        for (borrow borrow : getborrow) {
            int bid = borrow.getBid();
            book getbook = mapper.getbook(bid);
            System.out.println(getbook);
            int sid = borrow.getSid();
            Student getstudent = mapper.getstudent(sid);
            System.out.print("�����ˣ�");
            System.out.println(getstudent);
        }


        System.out.println("===========");

    }

    private  static void addBorrow(){
        System.out.println("�������鼮��");
        String s = Utility.readString(4);
        int bid = Integer.parseInt(s);
        System.out.println("������ѧ��");
        int sid = Utility.readInt();
        mapper.addborrow(sid,bid);

    }
  public static void   student(){
      System.out.print("����������");
      String m = Utility.readString(10);
      System.out.println("�����Ա�");
      String s = Utility.readString(2);
      System.out.println("ʱ��");
      int y = Utility.readInt();
      Student student = new Student(m,s,y);
      int i = mapper.addStudent(student);
      if (i>0){
          log.info("�����һ��ѧ����Ϣ��"+student);
      }else {
          log.info("����ѧ��ʧ��");
      }
  }
  public  static void  book(){
      System.out.print("�鼮����:");
      String m = Utility.readString(10);
      System.out.print("�鼮��ע:");
      String s = Utility.readString(1);
      System.out.print("��Ǯ:");
      int j = Utility.readInt();
      book book = new book(m, s, j);
      int addbook = mapper.addbook(book);
      if (addbook>0){
          log.info("�����һ���鼮"+book);
      }else {
          log.info("�����鼮ʧ��");
      }

  }
}
