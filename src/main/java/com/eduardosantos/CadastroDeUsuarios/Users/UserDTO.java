package com.eduardosantos.CadastroDeUsuarios.Users;

import com.eduardosantos.CadastroDeUsuarios.Projects.ProjectModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String name;

    private int age;

    private String email;

    private String department;

    private String jobTitle;

    private ProjectModel project;

}
