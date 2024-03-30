package com.example.Shop.Management.Controller;

import com.example.Shop.Management.Model.User;
import com.example.Shop.Management.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
   UserService userservice;

   @PostMapping("/registration")
    public String register(@RequestBody User user){
       String res=userservice.register(user);
       return res;

   }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user){
        String email=user.getEmail();
        String password=user.getPassword1();

        //System.out.println(user.getPassword());
        String result=userservice.userLogin(email,password);

        return result;
    }

}
