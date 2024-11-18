package com.Hotelwebsite.Apllication.service;


import com.Hotelwebsite.Apllication.model.UserModel;
import com.Hotelwebsite.Apllication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserModelService {

    private final UserRepository userRepository;

    @Autowired
    public UserModelService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserModel> findById(Long id) {
        return userRepository.findById(id);
    }

    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
