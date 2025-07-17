package com.eduardosantos.CadastroDeUsuarios.Projects;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private  ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectModel> listProjects(){
        return projectRepository.findAll();
    }

}
