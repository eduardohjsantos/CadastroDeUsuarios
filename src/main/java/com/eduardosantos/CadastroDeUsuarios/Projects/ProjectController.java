package com.eduardosantos.CadastroDeUsuarios.Projects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @PostMapping("/create")
    public ResponseEntity<String> createProject(@RequestBody ProjectDTO project){

        ProjectDTO projectDTO = projectService.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Project created successfully " + projectDTO.getTitle() + " (ID): " + projectDTO.getId());
    }


    @GetMapping("/list")
    public ResponseEntity<List<ProjectDTO>> listProjects(){
        return ResponseEntity.ok(projectService.listProjects());
    }


    @GetMapping("/list/{id}")
    public ResponseEntity<?> listProjectsById(@PathVariable Long id){

        ProjectDTO projectDTO = projectService.listProjectsById(id);
        if(projectDTO != null){
            return ResponseEntity.ok(projectDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Project with ID: " + id + " not found");
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProjectById(@PathVariable Long id, @RequestBody ProjectDTO projectDTO){

        ProjectDTO updatedProject = projectService.updateProject(id,projectDTO);
        if(updatedProject != null){
            return ResponseEntity.ok(updatedProject);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Project with ID: " + id + " not found");
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProjectById(@PathVariable Long id){

        if(projectService.listProjectsById(id) != null){
            projectService.deleteProject(id);
            return ResponseEntity.ok("Project with ID: " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Project with ID: " + id + " not found");
        }
    }
}
