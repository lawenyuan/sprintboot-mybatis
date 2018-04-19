package com.example.controller;

import com.example.entity.Student;
import com.example.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/findall")
    public List<Student> findAll(){
        return studentMapper.findAll();
    }

    @GetMapping("/findbyuid")
    public Student findByUid(@RequestParam("uid") int uid){
        return studentMapper.findByUid(uid);
    }

    @GetMapping("add")
    public List<Student> add(@RequestParam("uname") String uname, @RequestParam("sex") int sex){
        Student s = new Student();
        s.setSex(sex);
        s.setUname(uname);
        studentMapper.add(s);
        return studentMapper.findAll();
    }

    @GetMapping("/delete")
    public List<Student> deleteByUid(@RequestParam("uid") int uid){
        studentMapper.deleteByUid(uid);
        return studentMapper.findAll();
    }
}
