package com.baidu.hellospringboot.service;

import com.baidu.hellospringboot.entity.Student;
import com.baidu.hellospringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther:zcf
 * @Date:2019/12/12
 * @Descirption:com.baidu.hellospringboot.service
 * @version:1.0
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Transactional
    public void insertTwo(){
        Student student1=new Student();
        student1.setName("studentA");
        student1.setAge(22);
        Student student2=new Student();
        student2.setName("studentB");
        student2.setAge(33);
        studentRepository.save(student1);
        int i=1/0;
        studentRepository.save(student2);

    }
}
