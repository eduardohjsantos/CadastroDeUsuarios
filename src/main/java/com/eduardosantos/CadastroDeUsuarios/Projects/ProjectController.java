package com.eduardosantos.CadastroDeUsuarios.Projects;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProjectController {

    // Add project (CREATE)
    @PostMapping("/createproject")
    public String createProject(){
        return "Project created";
    }

    // Show all users (READ)
    @GetMapping("/allprojects")
    public String showAllProjects(){
        return "Showing all projects";
    }

    // Search user by id (READ)
    @GetMapping("/projectID")
    public String showProjectById(){
        return "Showing project with selected id";
    }

    // Change user data (UPDATE)
    @PutMapping("/updateprojectID")
    public String updateProjectById(){
        return "Update project by id";
    }

    // Delete user (DELETE)
    @DeleteMapping("/deleteprojectID")
    public String deleteProjectById(){
        return "Delete project by id";
    }
}
