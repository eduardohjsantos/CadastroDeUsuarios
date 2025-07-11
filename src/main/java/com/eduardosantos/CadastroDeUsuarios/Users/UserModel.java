package com.eduardosantos.CadastroDeUsuarios.Users;

import com.eduardosantos.CadastroDeUsuarios.Projects.ProjectModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String email;

    private String department;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectModel project;

    public UserModel() {
    }
    public UserModel(String name, int age, String email, String department) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
