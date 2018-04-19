package com.example.mapper;

import com.example.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select uid, uname, sex from student")
    @Results({
            @Result(property = "uname" , column = "uname"),
            @Result(property = "sex", column = "sex")
    })
    List<Student> findAll();

    @Select("select uid, uname, sex from student where uid=#{uid}")
    @Results({
            @Result(property = "uname" , column = "uname"),
            @Result(property = "sex", column = "sex")
    })
    Student findByUid(int uid);

    @Insert("insert into student(uname,sex) values(#{uname}, #{sex})")
    void add(Student s);

    @Delete("delete from student where uid=#{uid}")
    void deleteByUid(int uid);
}
