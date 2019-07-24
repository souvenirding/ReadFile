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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    private static final String path = "C:\\Users\\14065\\Desktop\\";

    //处理上传的文件
    @RequestMapping("/file")
    public String getStudentFile(@RequestParam("uploadFile") String uploadFile,Model model) {

        long startTime = System.currentTimeMillis();

//        String path = "C:\\Users\\14065\\Desktop\\"+uploadFile;
//        System.out.println(path);
        File file = new File(path+uploadFile);
        List<Student> list = ReadExcel.readExcel(file);
        //插入数据库
        for (Student s:list) {
            studentService.insertStudent(s);
        }
        model.addAttribute("studentlist",list);

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间" + (endTime - startTime) + "ms");

        return "studentlist";
    }

}
