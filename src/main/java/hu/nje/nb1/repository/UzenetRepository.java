package hu.nje.nb1.repository;

import hu.nje.nb1.model.Uzenet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UzenetRepository extends JpaRepository<Uzenet, Integer> {

    // Minden üzenet fordított időrendben
    List<Uzenet> findAllByOrderByKuldesIdejeDesc();
}