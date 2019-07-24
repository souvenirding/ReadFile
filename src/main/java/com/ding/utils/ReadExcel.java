package com.ding.utils;

import com.ding.pojo.Student;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    //读取文件内容并保存为List<Student>
    public static List readExcel(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();

            for (int index = 0; index < sheet_size; index++) {
                List<List> outerList = new ArrayList<List>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    List innerList = new ArrayList();
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if (cellinfo.isEmpty()) {
                            continue;
                        }
                        innerList.add(cellinfo);
                        //System.out.println(innerList);
                    }
                    outerList.add(i, innerList);
                    //System.out.println(innerList);
                }
                //将读取的数据存为List<Student>
                List<Student> studentList = new ArrayList<Student>();
                //从m=1开始，去掉标题栏
                for (int m = 1; m < outerList.size(); m++) {
                    Student student = new Student();
                    List list = (List) outerList.get(m);
                    int j = 0;
                    while (j < list.size()) {
                        student.setId(Integer.parseInt(String.valueOf(list.get(0))));
                        student.setStudentname(list.get(1).toString());
                        student.setStudentage(Integer.parseInt(String.valueOf(list.get(2))));
                        student.setStudentsex(list.get(3).toString());
                        //System.out.println(Student);
                        studentList.add(student);
                        j = list.size();
                    }
                }
                return studentList;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
