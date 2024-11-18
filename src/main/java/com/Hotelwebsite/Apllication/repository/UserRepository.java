package com.Hotelwebsite.Apllication.repository;


import com.Hotelwebsite.Apllication.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
}
