package com.baidu.hellospringboot.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther:zcf
 * @Date:2019/12/12
 * @Descirption:com.baidu.hellospringboot.entity
 * @version:1.0
 */
@ConfigurationProperties(prefix = "student")
@Component
public class StudentTest {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
