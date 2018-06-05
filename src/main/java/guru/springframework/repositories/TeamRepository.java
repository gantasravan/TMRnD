package guru.springframework.repositories;

import guru.springframework.domain.Product;
import guru.springframework.domain.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
