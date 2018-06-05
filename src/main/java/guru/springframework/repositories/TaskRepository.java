package guru.springframework.repositories;

import guru.springframework.domain.Task;
import guru.springframework.domain.Team;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
