package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
  List<User> findByUserNameLike(String userName);
  List<User> findByNickNameLike(String nickName);
  
  @Query("Select u.userName from User u where u.nickName = :nn")
  List<String> findNames(@Param("nn") String nn);
  
}
