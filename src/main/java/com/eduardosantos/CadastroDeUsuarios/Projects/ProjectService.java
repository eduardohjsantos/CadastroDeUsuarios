package com.eduardosantos.CadastroDeUsuarios.Projects;


import com.eduardosantos.CadastroDeUsuarios.Users.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private  ProjectRepository projectRepository;
    private  ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    // Lists all projects
    public List<ProjectModel> listProjects(){
        return projectRepository.findAll();
    }

    // Lists projects by ID
    public ProjectModel listProjectsById(Long id){
        Optional<ProjectModel> projectById = projectRepository.findById(id);
        return  projectById.orElse(null);
    }

    // Create a new project
    public ProjectDTO createProject(ProjectDTO projectDTO){
        ProjectModel project = projectMapper.map(projectDTO);
        project = projectRepository.save(project);
        return projectMapper.map(project);
    }

    // Delete a project
    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }

    // Update a project
    public ProjectModel updateProject(Long id, ProjectModel updatedProject){
        if(projectRepository.existsById(id)){
            updatedProject.setId(id);
            return projectRepository.save(updatedProject);
        }
        return null;
    }
}
