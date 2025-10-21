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
    public UserDTO createUser(@RequestBody UserDTO user){
        return userService.createUser(user);
    }

    // Show all users (READ)
    @GetMapping("/list")
    public List<UserDTO> listUsers(){
        return userService.listUsers();
    }

    // Search user by id (READ)
    @GetMapping("/list/{id}")
    public UserDTO listUsersById(@PathVariable Long id){
        return userService.listUsersById(id);
    }

    // Change user data (UPDATE)
    @PutMapping("/update/{id}")
    public UserDTO updateUserById(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.updateUser(id, userDTO);
    }

    // Delete user (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
    }


}
