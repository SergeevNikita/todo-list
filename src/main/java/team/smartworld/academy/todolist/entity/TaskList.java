package team.smartworld.academy.todolist.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * TaskList model
 *
 * @author Sergeev Nikita
 * @version 1.0
 */

@Entity
@Data
public class TaskList {
    /**
     * ID
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Дата создания
     */

    private LocalDateTime dateCreated;
    /**
     * Дата изменения
     */

    private LocalDateTime dateChange;
    /**
     * Название списка
     */
    @NotNull
    @Size(min = 1, max = 30)
    private String name;
    /**
     * Состояние (завершено или нет)
     */

    private boolean isDone;

    /**
     * Количество завершенных Task
     */

    private Long numberOfCompletedTask;

    /* Список дел (нужно ли?) */

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Task> tasks;

    
}