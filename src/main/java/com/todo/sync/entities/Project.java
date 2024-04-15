package com.todo.sync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "fecha_creacion")
    private LocalDate creationDate;

    @Column(name = "fecha_vencimiento")
    private LocalDate dueDate;

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
