package com.eduardosantos.CadastroDeUsuarios.Projects;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("projects")
public class ProjectController {

    // Add project (CREATE)
    @PostMapping("/create")
    public String createProject(){
        return "Project created";
    }

    // Show all users (READ)
    @GetMapping("/list")
    public String showAllProjects(){
        return "Showing all projects";
    }

    // Search user by id (READ)
    @GetMapping("/listID")
    public String showProjectById(){
        return "Showing project with selected id";
    }

    // Change user data (UPDATE)
    @PutMapping("/updateID")
    public String updateProjectById(){
        return "Update project by id";
    }

    // Delete user (DELETE)
    @DeleteMapping("/deleteID")
    public String deleteProjectById(){
        return "Delete project by id";
    }
}
