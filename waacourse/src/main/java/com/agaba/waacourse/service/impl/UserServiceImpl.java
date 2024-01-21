package com.agaba.waacourse.service.impl;

import com.agaba.waacourse.entity.Post;
import com.agaba.waacourse.entity.User;
import com.agaba.waacourse.entity.response.UserDto;
import com.agaba.waacourse.repo.UserRepo;
import com.agaba.waacourse.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
    @Override
    public UserDto findById(long id) {
        return modelMapper.map(userRepo.findById(id), UserDto.class);
    }

    public List<Post> findPostbyUserId(long id){
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()){
            return optionalUser.get().getPosts();
        }
        return new ArrayList<>();
    }

    @Override
    public List<User> findUsersWithMoreThanOnePost(int count) {
        return userRepo.findUsersWithMoreThanOnePost(count);
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

}
