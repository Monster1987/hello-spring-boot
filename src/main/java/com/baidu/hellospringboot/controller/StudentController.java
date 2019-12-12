package com.baidu.hellospringboot.controller;

import com.baidu.hellospringboot.entity.Student;
import com.baidu.hellospringboot.repository.StudentRepository;
import com.baidu.hellospringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther:zcf
 * @Date:2019/12/12
 * @Descirption:com.baidu.hellospringboot.Controller
 * @version:1.0
 */
@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    //查询所有学生信息
    @GetMapping(value = "/stus")
    public List<Student> studentList(){
        return studentRepository.findAll();

    }

    //添加一个学生信息
    @PostMapping(value ="/stus" )
    public Student addStudent(@RequestParam("name")String name,
                             @RequestParam("age") Integer age){
        Student student=new Student();
        student.setName(name);
        student.setAge(age);
        //student.setId(3);
        return studentRepository.save(student);
    }

    //通过id查询学生
    @GetMapping(value = "/stus/{id}")
    public Student findStudentById(@PathVariable("id") Integer id){
        return studentRepository.findById(id).orElse(null);
    }


    //通过年龄查询学生
    @GetMapping(value = "/stus/age/{age}")
    public List<Student> findStudentsByAge(@PathVariable("age") Integer age){
        return studentRepository.findByAge(age);
    }

    //通过id更新学生
    @PutMapping(value = "/stus/{id}")
    public Student updateStudentById(@PathVariable("id") Integer id,
                                     @RequestParam("name")String name,
                                     @RequestParam("age") Integer age){
        Student student=new Student();
        student.setId(id);
        student.setAge(age);
        student.setName(name);
        return studentRepository.save(student);
    }

    //通过id删除学生
    @DeleteMapping(value = "/stus/{id}")
    public void deleteStudent(@PathVariable("id") Integer id){
        Student student=new Student();
        student.setId(id);
        studentRepository.delete(student);
    }

    //同时添加两个学生（事务）
    @PostMapping(value = "stus/two")
    public void insertTwo(){
        studentService.insertTwo();
    }

}
