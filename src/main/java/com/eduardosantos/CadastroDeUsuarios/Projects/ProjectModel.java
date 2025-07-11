package com.eduardosantos.CadastroDeUsuarios.Projects;

import com.eduardosantos.CadastroDeUsuarios.Users.UserModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_projects")
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String difficulty;

    @OneToMany(mappedBy = "project")
    private List<UserModel> users;


}
