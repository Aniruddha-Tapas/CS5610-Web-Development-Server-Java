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

    @PostMapping("/api/register")
    public User register(@RequestBody User user, HttpSession session) {
        User user1 = userRepository.findUserByUsername(user.getUsername());
        if (user1 == null) {
            User cUser = userRepository.save(user);
            session.setAttribute("currentUser", cUser);
            return cUser;
        } else {
            session.invalidate();
            return null;
        }
    }

    @GetMapping("/api/profile")
    public User profile(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (userRepository.findById(currentUser.getId()).isPresent()) {
            User user = userRepository.findById(currentUser.getId()).get();
            return user;
        }
        return null;
    }

    @PostMapping("/api/login")
    public User login(@RequestBody User user, HttpSession session) {
        user = userRepository.findUserByCredentials(user.getUsername(), user.getPassword());
        if (user != null) {
            session.setAttribute("currentUser", user);
            return user;
        } else {
            session.invalidate();
            return null;
        }
    }

    @PostMapping("/api/logout")
    public void logout( HttpSession session) {
        session.removeAttribute("currentUser");
        session.invalidate();
    }


    /*
    //REGISTER USER
    @PostMapping("/api/register")
    public User register(@RequestBody User user, HttpServletResponse httpServletResponse) {
        User user1 = userRepository.findUserByUsername(user.getUsername());
        if (user1 == null) {
            return userRepository.save(user);
        } else {
            httpServletResponse.setStatus(HttpServletResponse.SC_CONFLICT);
            return null;
        }
    }

    //LOGIN USER
    @PostMapping("/api/login")
    public User login(@RequestBody User user, HttpServletResponse httpServletResponse) {
        User user1 = userRepository.findUserByCredentials(user.getUsername(), user.getPassword());
        if (user1 != null) {
            return user1;
        } else {
            httpServletResponse.setStatus(HttpServletResponse.SC_CONFLICT);
            return null;
        }
    }*/

    @GetMapping("/api/user")
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
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
