package com.eduardosantos.CadastroDeUsuarios.Users;


import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // List all users
    public List<UserModel> listUsers(){
        return userRepository.findAll();
    }

    // List users by ID
    public UserModel listUsersById(Long id){
        Optional<UserModel> userById = userRepository.findById(id);
        return userById.orElse(null);
    }

    // Create a new user
    public UserDTO createUser(UserDTO userDTO){
        UserModel user = userMapper.map(userDTO);
        user = userRepository.save(user);
        return userMapper.map(user);

    }

    // Delete a user
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    // Update a user
    public UserModel updateUser(Long id, UserModel updatedUser){
        if(userRepository.existsById(id)){
            updatedUser.setId(id);
            return userRepository.save(updatedUser);
        }
        return null;
    }
}
