package com.manage.mapper;

import com.manage.entlty.Student;
import com.manage.entlty.book;
import com.manage.entlty.borrow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface BookMapper {
    @Insert("insert into student(name ,sex,grade) values(#{name},#{sex},#{grade})")
    int addStudent(Student student);

    @Insert("insert into book (title, `desc`, price) VALUES (#{title},#{desc},#{price})")
    int addbook(book book);

    @Insert("insert into borrow(sid,bid) values (#{sid},#{bid})")
    int addborrow(@Param("sid")int  sid,@Param("bid") int bid);

    @Select("select * from borrow ")
    List<borrow> getborrow();
    @Select("select * from book where bid=#{bid}")
   book getbook(int bid);


    @Select("select * from  student where sid=#{sid}")
    Student getstudent(int sid);
}
