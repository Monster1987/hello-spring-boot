package com.baidu.hellospringboot.Controller;

import com.baidu.hellospringboot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther:zcf
 * @Date:2019/12/12
 * @Descirption:com.baidu.hellospringboot.Controller
 * @version:1.0
 */
@RestController
public class HelloController {
    @Value("${name}")
    private String myname;
    @Autowired
    private Student student;
    @RequestMapping(value = {"/hello1","hi"},method = RequestMethod.GET)
    public String show1(){
        return "hello spring-boot "+myname;
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String show2(){
        return student.getName()+" "+student.getAge();
    }

    @RequestMapping(value = "hello3/{id}",method = RequestMethod.GET)
    public String show3(@PathVariable("id") Integer myid){
        return myid+"";

    }

    //@RequestMapping(value = "/hello4",method = RequestMethod.GET)
    @GetMapping("/hello4")
    public String show4(@RequestParam(value = "id",required = false,defaultValue = "0503")
                                    Integer myid){
        return myid+"";

    }
}
