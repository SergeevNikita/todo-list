package team.smartworld.academy.todolist.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Класс описания сущьности TaskList
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
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
    private boolean done;
    /**
     * Количество завершенных Task
     */
    private Long numberOfCompletedTask;
    /**
     * Список обьектов Task
     */
    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Task> tasks;
}
