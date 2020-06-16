package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
  List<User> findByUserNameLike(String userName);
  List<User> findByNickNameLike(String nickName);
  
}
