package com.example.wedevsummer2assignment1.services;

import com.example.wedevsummer2assignment1.models.User;
import com.example.wedevsummer2assignment1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
public class UserService {

    @Autowired
    UserRepository userRepository;

    //CREATE USER
    @PostMapping("/api/user")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    //READ USER
    @GetMapping("/api/user/{userId}")
    public User findUserById(@PathVariable("userId") String userId) {
        int id;
        try {
            id = Integer.parseInt(userId);
        }catch (Exception e){
            return null;
        }
        if (userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        return null;
    }


    @GetMapping("/api/user")
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    //UPDATE USER
    @PutMapping("/api/user/{userId}")
    public User updateUser(@PathVariable("userId") String userId,
                           @RequestBody User user) {
        int id;
        try {
            id = Integer.parseInt(userId);
        }catch (Exception e){
            return null;
        }
        if (userRepository.findById(id).isPresent()) {
            User user1 = userRepository.findById(id).get();
            user1.setUser(user);
            return userRepository.save(user1);
        }
        return null;
    }

    //DELETE USER
    @DeleteMapping("/api/user/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        userRepository.deleteById(userId);
    }

    //REGISTER USER
    @PostMapping("/api/register")
    public User register(@RequestBody User user, HttpSession session,  HttpServletResponse httpServletResponse) {
        User user1 = userRepository.findUserByUsername(user.getUsername());
        if (user1 == null) {
            User cUser = userRepository.save(user);
            session.setAttribute("currentUser", cUser);
            return cUser;
        } else {
            session.invalidate();
            httpServletResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return null;
        }
    }

    //READ USER PROFILE
    @GetMapping("/api/profile")
    public User profile(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (userRepository.findById(currentUser.getId()).isPresent()) {
            User user = userRepository.findById(currentUser.getId()).get();
            return user;
        }
        return null;
    }

    //LOGIN
    @PostMapping("/api/login")
    public User login(@RequestBody User user, HttpSession session, HttpServletResponse httpServletResponse) {
        user = userRepository.findUserByCredentials(user.getUsername(), user.getPassword());
        if (user != null) {
            session.setAttribute("currentUser", user);
            return user;
        } else {
            session.invalidate();
            httpServletResponse.setStatus(HttpServletResponse.SC_CONFLICT);
            return null;
        }
    }


    //LOGOUT
    @PostMapping("/api/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }


    //UPDATE USER PROFILE
    @PutMapping("/api/profile/{userId}")
    public User updateProfile(@PathVariable("userId") String userId,
                              @RequestBody User user) {
        int id;
        try {
            id = Integer.parseInt(userId);
        }catch (Exception e){
            return null;
        }
        if (userRepository.findById(id).isPresent()) {
            User user1 = userRepository.findById(id).get();
            user1.setUser(user);
            return userRepository.save(user1);
        }
        return null;
    }
}
