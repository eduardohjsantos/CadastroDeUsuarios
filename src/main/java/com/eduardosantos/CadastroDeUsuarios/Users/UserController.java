package com.eduardosantos.CadastroDeUsuarios.Users;

import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota.";
    }

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Add user (CREATE)
    @PostMapping("/create")
    public UserModel createUser(@RequestBody UserModel user){
        return userService.createUser(user);
    }

    // Show all users (READ)
    @GetMapping("/list")
    public List<UserModel> listUsers(){
        return userService.listUsers();
    }

    // Search user by id (READ)
    @GetMapping("/list/{id}")
    public UserModel listUsersById(@PathVariable Long id){
        return userService.listUsersById(id);
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
