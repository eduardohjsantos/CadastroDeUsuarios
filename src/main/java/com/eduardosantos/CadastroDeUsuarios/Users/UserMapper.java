package com.eduardosantos.CadastroDeUsuarios.Users;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModel map(UserDTO userDTO){

        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getId());
        userModel.setName(userDTO.getName());
        userModel.setAge(userDTO.getAge());
        userModel.setEmail(userDTO.getEmail());
        userModel.setDepartment(userDTO.getDepartment());
        userModel.setJobTitle(userDTO.getJobTitle());
        userModel.setProject(userDTO.getProject());

        return userModel;
    }

    public UserDTO map(UserModel userModel){

        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setName(userModel.getName());
        userDTO.setAge(userModel.getAge());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setDepartment(userModel.getDepartment());
        userDTO.setJobTitle(userModel.getJobTitle());
        userDTO.setProject(userModel.getProject());

        return userDTO;
    }
}
