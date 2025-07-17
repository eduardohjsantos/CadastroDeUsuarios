package com.eduardosantos.CadastroDeUsuarios.Projects;

import com.eduardosantos.CadastroDeUsuarios.Users.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "difficulty")
    private String difficulty;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<UserModel> users;


}
