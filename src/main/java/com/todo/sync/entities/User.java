package com.todo.sync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombres")
    @NotEmpty
    private String name;
    @Column(name = "apellidos")
    @NotEmpty
    private String lastname;
    @Column(name = "sexo")
    private String gender;
    @Column(name = "correo")
    @NotEmpty
    @Email
    private String email;
    @Column(name = "contrasena")
    @NotEmpty
    private String password;
    @Column(name = "celular")
    @NotNull
    private String phone;
    @Column(name = "foto_perfil")
    private String profilePicture;
    @Column(name = "disponible")
    private boolean available;
    @Column(name = "fecha_registro")
    private LocalDateTime registrationDate;
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Role role;
    @Column(name = "token_autenticacion")
    private String authenticationToken;
    @ManyToMany(mappedBy = "assignedUsers")
    private Set<Task> tasks;

    public User() {
        super();
    }
}
