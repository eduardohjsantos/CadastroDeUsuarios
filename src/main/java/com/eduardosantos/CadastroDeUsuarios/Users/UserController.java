package com.eduardosantos.CadastroDeUsuarios.Users;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Welcome message", description = "This route shows a welcome message")
    public String boasVindas(){
        return "Welcome!";
    }

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    @Operation(summary = "Creates a new user", description = "This route creates a new user and inserts into the database")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "201", description = "User created successfully"),
            @ApiResponse( responseCode = "400", description = "Error creating user")
    })
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
    @Operation(summary = "List user by Id", description = "Route lists a user by Id")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200", description = "User found"),
            @ApiResponse( responseCode = "404", description = "User not found")
    })
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
    @Operation(summary = "Updates user by Id", description = "Route updates a user by Id")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200", description = "User updated successfully"),
            @ApiResponse( responseCode = "404", description = "User not found")
    })
    public ResponseEntity<?> updateUserById(
            @Parameter(description = "The user ID is provided in the request path")
            @PathVariable Long id,
            @Parameter(description = "The updated user data is provided in the request body")
            @RequestBody UserDTO userDTO){
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
