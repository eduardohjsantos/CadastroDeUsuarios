package com.eduardosantos.CadastroDeUsuarios.Users;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
