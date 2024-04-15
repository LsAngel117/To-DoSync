package com.todo.sync.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "task_project_assignment")
@Getter
@Setter
public class TaskProjectAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;


    public TaskProjectAssignment() {
    }
}
