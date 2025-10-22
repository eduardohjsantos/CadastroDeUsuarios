package com.eduardosantos.CadastroDeUsuarios.Users;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDTO user){

        UserDTO userDTO = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User created successfully: " + userDTO.getName() + " (ID): " + userDTO.getId());
    }


    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> listUsers(){
        return ResponseEntity.ok(userService.listUsers());
    }


    @GetMapping("/list/{id}")
    public ResponseEntity<?> listUsersById(@PathVariable Long id){

        UserDTO userDTO = userService.listUsersById(id);
        if(userDTO != null){
            return  ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with id: " + id + " not found");

        }


    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable Long id, @RequestBody UserDTO userDTO){

        UserDTO updatedUser = userService.updateUser(id, userDTO);
        if(updatedUser != null){
            return ResponseEntity.ok(updatedUser);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID: " + id + " not found");
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){

        if(userService.listUsersById(id) != null){
            userService.deleteUser(id);
            return ResponseEntity.ok("User with ID: " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID: " + id + " not found");
        }
    }


}
