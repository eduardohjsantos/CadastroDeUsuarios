package com.eduardosantos.CadastroDeUsuarios.Users;


import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public List<UserDTO> listUsers(){
        List<UserModel> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }


    public UserDTO listUsersById(Long id){
        Optional<UserModel> userById = userRepository.findById(id);
        return userById.map(userMapper::map).orElse(null);
    }


    public UserDTO createUser(UserDTO userDTO){
        UserModel user = userMapper.map(userDTO);
        user = userRepository.save(user);
        return userMapper.map(user);
    }


    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


    public UserDTO updateUser(Long id, UserDTO userDTO){
        Optional<UserModel> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()){
            UserModel updatedUser = userMapper.map(userDTO);
            updatedUser.setId(id);
            UserModel savedUser = userRepository.save(updatedUser);
            return userMapper.map(savedUser);
        }
        return null;
    }
}
