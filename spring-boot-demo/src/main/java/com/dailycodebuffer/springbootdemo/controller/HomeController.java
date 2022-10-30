package com.dailycodebuffer.springbootdemo.controller;

import com.dailycodebuffer.springbootdemo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Hello Dipanjan,  How are you?";
    }

   // @RequestMapping(value = "/user", method = RequestMethod.POST)
    @GetMapping("/user")
    public User user() {
        User user = new User();
        user.setId("USR-1001");
        user.setName("Dipanjan");
        user.setEmail_id("das.dipanjan@hotmail.com");
        return user;
    }

    @GetMapping("/{id}/{name}")
    public String pathVariableExample(@PathVariable("id") String id, @PathVariable("name") String name) {
        return "The Path Variable is: " + id + " : " + name;
    }

    @GetMapping("/requestParam")
    public String requestParam(@RequestParam(name = "name")
                                   String name, @RequestParam(name = "email", required = false, defaultValue = "") String emailid) {
        return "Your Name is := " + name + " and "+"EmailID is := "+emailid;
    }
}
