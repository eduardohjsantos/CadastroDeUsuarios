package com.eduardosantos.CadastroDeUsuarios.Users;

import com.eduardosantos.CadastroDeUsuarios.Projects.ProjectModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @Column(unique = true)
    private String email;

    private String department;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectModel project;

}
