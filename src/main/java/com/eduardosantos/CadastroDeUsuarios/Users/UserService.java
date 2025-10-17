package com.eduardosantos.CadastroDeUsuarios.Users;


import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public UserModel createUser(UserModel user){
        return userRepository.save(user);
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
