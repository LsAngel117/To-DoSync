package com.todosync.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "proyectos")
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    @NotEmpty(message = "El proyecto debe tener un nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;
    @NotNull(message = "El proyecto debe tener una fecha de inicio")
    @Column(name = "fecha_creacion")
    private LocalDate creationDate;
    @NotNull(message = "El proyecto debe tener una fecha de vencimiento")
    @Column(name = "fecha_vencimiento")
    private LocalDate dueDate;
    @Column(name = "estado")
    private String status;

    @ManyToMany
    @JoinTable(
            name = "proyectos_tareas",
            joinColumns = @JoinColumn(name = "proyecto_id"),
            inverseJoinColumns = @JoinColumn(name = "tarea_id")
    )
    private Set<Task> tasks;

    @ManyToMany
    @JoinTable(
            name = "proyectos_usuarios",
            joinColumns = @JoinColumn(name = "proyecto_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private Set<User> users;

    public Project() {
    }
}
