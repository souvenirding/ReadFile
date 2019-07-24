package com.ding.service;

import com.ding.dao.StudentMapper;
import com.ding.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public int insertStudent(Student student){
        return studentMapper.insert(student);
    }
}
