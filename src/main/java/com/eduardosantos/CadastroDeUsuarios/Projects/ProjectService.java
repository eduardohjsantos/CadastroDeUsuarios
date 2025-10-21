package com.eduardosantos.CadastroDeUsuarios.Projects;


import com.eduardosantos.CadastroDeUsuarios.Users.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private  ProjectRepository projectRepository;
    private  ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }


    public List<ProjectDTO> listProjects(){
        List<ProjectModel> projects = projectRepository.findAll();
        return projects.stream()
                .map(projectMapper::map)
                .collect(Collectors.toList());
    }


    public ProjectDTO listProjectsById(Long id){
        Optional<ProjectModel> projectById = projectRepository.findById(id);
        return  projectById.map(projectMapper::map).orElse(null);
    }


    public ProjectDTO createProject(ProjectDTO projectDTO){
        ProjectModel project = projectMapper.map(projectDTO);
        project = projectRepository.save(project);
        return projectMapper.map(project);
    }


    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }


    public ProjectDTO updateProject(Long id, ProjectDTO projectDTO){
        Optional<ProjectModel> existingProject = projectRepository.findById(id);
        if (existingProject.isPresent()){
            ProjectModel updatedProject = projectMapper.map(projectDTO);
            updatedProject.setId(id);
            ProjectModel savedProject = projectRepository.save(updatedProject);
            return projectMapper.map(savedProject);
        }
        return null;
    }
}
