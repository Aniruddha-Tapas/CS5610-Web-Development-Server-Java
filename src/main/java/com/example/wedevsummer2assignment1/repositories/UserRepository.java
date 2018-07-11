package com.example.wedevsummer2assignment1.repositories;

import com.example.wedevsummer2assignment1.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT user FROM User user WHERE user.username=:username AND user.password=:password")
    public User findUserByCredentials(@Param("username") String u,
                                        @Param("password") String p);

    @Query("SELECT user from User user WHERE user.username=:username")
    public User findUserByUsername(@Param("username") String u);

}