package com.eduardosantos.CadastroDeUsuarios.Users;

import org.springframework.web.bind.annotation.*;

import java.sql.Struct;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota.";
    }



    // Add user (CREATE)
    @PostMapping("/create")
    public String createUser(){
        return "User created";
    }

    // Show all users (READ)
    @GetMapping("/list")
    public String showAllUsers(){
        return "Showing all users";
    }

    // Search user by id (READ)
    @GetMapping("/listID")
    public String showUserById(){
        return "Showing user with selected id";
    }

    // Change user data (UPDATE)
    @PutMapping("/updateID")
    public String updateUserById(){
        return "Update user by id";
    }

    // Delete user (DELETE)
    @DeleteMapping("/deleteID")
    public String deleteUserById(){
        return "Delete user by id";
    }


}
