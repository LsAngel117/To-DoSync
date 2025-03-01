package com.todosync.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tareas")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    @NotEmpty(message = "La tarea debe tener un título")
    private String title;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "prioridad")
    private String priority;
    @NotNull(message = "La tarea debe tener una fecha de ejecución")
    @Column(name = "fecha_creacion")
    private LocalDate creationDate;
    @NotNull(message = "La tarea debe tener una fecha de vencimiento")
    @Column(name = "fecha_vencimiento")
    private LocalDate dueDate;
    @Column(name = "categoria")
    private String category;
    @Column(name = "estado")
    private String status;
    @ManyToMany
    @JoinTable(
            name = "tareas_usuarios",
            joinColumns = @JoinColumn(name = "tarea_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private Set<User> assignedUsers;

    public Task() {
    }
}
