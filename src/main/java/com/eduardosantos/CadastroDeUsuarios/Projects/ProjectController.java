package com.eduardosantos.CadastroDeUsuarios.Projects;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // Add project (CREATE)
    @PostMapping("/create")
    public String createProject(){
        return "Project created";
    }

    // Show all users (READ)
    @GetMapping("/list")
    public List<ProjectModel> listProjects(){
        return projectService.listProjects();
    }

    // Search user by id (READ)
    @GetMapping("/list/{id}")
    public ProjectModel listProjectsById(@PathVariable Long id){
        return projectService.listProjectsById(id);
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
