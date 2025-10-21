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
    public ProjectDTO createProject(@RequestBody ProjectDTO project){
        return projectService.createProject(project);
    }

    // Show all users (READ)
    @GetMapping("/list")
    public List<ProjectDTO> listProjects(){
        return projectService.listProjects();
    }

    // Search user by id (READ)
    @GetMapping("/list/{id}")
    public ProjectDTO listProjectsById(@PathVariable Long id){
        return projectService.listProjectsById(id);
    }

    // Change user data (UPDATE)
    @PutMapping("/update/{id}")
    public ProjectDTO updateProjectById(@PathVariable Long id, @RequestBody ProjectDTO projectDTO){
        return projectService.updateProject(id,projectDTO);
    }

    // Delete user (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteProjectById(@PathVariable Long id){
        projectService.deleteProject(id);
    }
}
