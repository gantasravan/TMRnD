package guru.springframework.repositories;

import guru.springframework.domain.TeamSkill;
import org.springframework.data.repository.CrudRepository;

public interface TeamSkillRepository extends CrudRepository<TeamSkill, Long> {
}
