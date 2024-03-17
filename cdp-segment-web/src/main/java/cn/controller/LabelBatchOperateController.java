package cn.controller;

import cn.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


//Rest模式
@Slf4j
@RestController
@RequestMapping("/test")
public class LabelBatchOperateController {

    //服务部署测试
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("---------------hello-----------------");
        log.info("---------------hello-----------------");
        return "服务部署测试！";
    }

    //服务部署测试
    @GetMapping("/hello2")
    public String hello2() {
        System.out.println("---------------hello-----------------");
        log.info("---------------hello-----------------");
        return "服务部署测试！";
    }

    @PostMapping("/add")
    public User saveUser(User user) {
        log.info("save user,params:{}", user);
        String userId = UUID.randomUUID().toString().replaceAll("-", "");
        user.setUserId(userId);
        log.info(user.toString());
        return user;
    }


    /**
     * 根据id修改用户信息
     *
     * @return
     */
    @PostMapping("/updatePage")
    public String updatePage(Model model, User user) {
        log.info("save user,params:{}", user);
        String userId = UUID.randomUUID().toString().replaceAll("-", "");
        user.setUserId(userId);
        log.info(user.toString());
        return "modifie";
    }

}
