package hu.nje.nb1.repository;

import hu.nje.nb1.model.Klub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlubRepository extends JpaRepository<Klub, Integer> {
}
