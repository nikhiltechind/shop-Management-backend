package com.example.Shop.Management.Service;

import com.example.Shop.Management.Model.User;
import com.example.Shop.Management.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userrepository;
    private  TokenService tokenservice;
    @Autowired
    public UserService(UserRepository userRepoObj, TokenService tokenservice) {
        this.userrepository = userRepoObj;
        this.tokenservice = tokenservice;
    }

   public String register(User user){
      if(!existByEmail(user.getEmail())){
       User res=userrepository.save(user);
          System.out.println(res);
      return "Registration Successful";
      }
      else
       return "User Already Exist ";
   }

    public String userLogin(String email,String password){
        boolean foundUsers = existByEmail(email);
        if(foundUsers) {
            User userObj = userrepository.getUserByUsername(email);
            if(userObj.getPassword1().equals(password) || userObj.getPassword2().equals(password)){
                return "{" +
                        "\"message\":"+"Successfully logged in\",\n"+
                        "\"data\":"+userObj+",\n"+
                        "\"Email: "+ userObj.getEmail()+"\n"+
                        "\"token: "+ tokenservice.createToken(userObj.getUserId())+
                        "\""+
                        "}";
            }

        }


        return "{" +
                "\"message\":"+"Authentication failed\",\n"+
                "}";

    }

    public Boolean existByEmail(String email){
        Optional<User> usersObj = Optional.ofNullable(userrepository.getUserByUsername(email));
        //List<User> usersObj= userRepoObj.getUserByUsername(email);
        if(!usersObj.isEmpty()){
            return true;
        }
        return false;
    }
}
