package com.ding.controller;

import com.ding.pojo.Student;
import com.ding.service.StudentService;
import com.ding.utils.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    //处理上传的文件
    @RequestMapping("/file")
    public String getStudentFile(@RequestParam("uploadFile") MultipartFile uploadFile,Model model) throws IOException {
        long startTime = System.currentTimeMillis();

        List<Student> list = ReadExcel.readExcel(uploadFile.getInputStream());
        //插入数据库

            studentService.insertStudent(list);

        model.addAttribute("studentlist",list);

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间" + (endTime - startTime) + "ms");

        return "studentlist";
    }

}
