package com.eduardosantos.CadastroDeUsuarios.Projects;

import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public ProjectModel map(ProjectDTO projectDTO){

        ProjectModel projectModel = new ProjectModel();
        projectModel.setId(projectDTO.getId());
        projectModel.setTitle(projectDTO.getTitle());
        projectModel.setDifficulty(projectDTO.getDifficulty());
        projectModel.setUsers(projectDTO.getUsers());

        return projectModel;
    }

    public ProjectDTO map(ProjectModel projectModel){

        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(projectModel.getId());
        projectDTO.setTitle(projectModel.getTitle());
        projectDTO.setDifficulty(projectModel.getDifficulty());
        projectDTO.setUsers(projectModel.getUsers());

        return projectDTO;

    }
}
