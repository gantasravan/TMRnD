package guru.springframework.domain;

import guru.springframework.converters.Global;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Sravan
 */
@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TASK_ID", nullable = false)
    @Size(min = 1, max = Global.VARCHAR100)
    private String taskId;

    @Column(name = "SKILL", nullable = false)
    @Size(min = 1, max = Global.VARCHAR100)
    private String skill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
