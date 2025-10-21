package com.eduardosantos.CadastroDeUsuarios.Projects;

import com.eduardosantos.CadastroDeUsuarios.Users.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private Long id;

    private String title;

    private String difficulty;

    private List<UserModel> users;
}
