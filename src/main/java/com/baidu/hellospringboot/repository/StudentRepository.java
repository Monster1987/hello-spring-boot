package com.baidu.hellospringboot.repository;

import com.baidu.hellospringboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther:zcf
 * @Date:2019/12/12
 * @Descirption:com.baidu.hellospringboot.repository
 * @version:1.0
 */
//下行注解@Repository不加也可以
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    //通过年龄查询学生（不是主键 可能返回多个）
    public List<Student> findByAge(Integer age);

}
