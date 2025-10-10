package com.eduardosantos.CadastroDeUsuarios.Projects;


import com.eduardosantos.CadastroDeUsuarios.Users.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private  ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
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

}
