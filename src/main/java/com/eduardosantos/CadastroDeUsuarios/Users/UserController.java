package com.eduardosantos.CadastroDeUsuarios.Users;

import org.springframework.web.bind.annotation.*;

import java.sql.Struct;

@RestController
@RequestMapping
public class UserController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota.";
    }




    // Add user (CREATE)
    @PostMapping("/createuser")
    public String createUser(){
        return "User created";
    }

    // Show all users (READ)
    @GetMapping("/allusers")
    public String showAllUsers(){
        return "Showing all users";
    }

    // Search user by id (READ)
    @GetMapping("/userID")
    public String showUserById(){
        return "Showing user with selected id";
    }

    // Change user data (UPDATE)
    @PutMapping("/updateuserID")
    public String updateUserById(){
        return "Update user by id";
    }

    // Delete user (DELETE)
    @DeleteMapping("/deleteuserID")
    public String deleteUserById(){
        return "Delete user by id";
    }


}
