package com.eduardosantos.CadastroDeUsuarios.Users;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users/ui")
public class UserControllerUi {

    private final UserService userService;

    public UserControllerUi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listUsers(Model model){
        List<UserDTO> users = userService.listUsers();
        model.addAttribute("users", users);
        return "listUsers";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
        return "redirect:/users/ui/list";
    }

    @GetMapping("/list/{id}")
    public String listUsersById(@PathVariable Long id, Model model){
        UserDTO userDTO = userService.listUsersById(id);
        if(userDTO != null){
            model.addAttribute("users", userDTO);
            return  "userDetails";
        } else {
            model.addAttribute("message", "User not found");
            return "listUsers";
        }
    }

    @GetMapping("/add")
    public String showFormAddUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "addUser";
    }

    @PostMapping("/save")
    public String createUser(@ModelAttribute UserDTO user, RedirectAttributes redirectAttributes) {
        userService.createUser(user);
        redirectAttributes.addFlashAttribute("message", "User created successfully!");
        return "redirect:/users/ui/list";
    }


}
