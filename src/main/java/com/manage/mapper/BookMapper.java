package com.manage.mapper;

import com.manage.entlty.Student;
import org.apache.ibatis.annotations.Insert;

public interface BookMapper {
    @Insert("insert into student(name ,sex,grde) values(#(name),#(sex),#(grade))")
    int addStudent(Student student);
}
