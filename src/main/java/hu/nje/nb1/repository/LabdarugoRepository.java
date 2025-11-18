package hu.nje.nb1.repository;

import hu.nje.nb1.model.Labdarugo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabdarugoRepository extends JpaRepository<Labdarugo, Integer> {
    boolean existsById(Integer id);
    long countByPoszt_Id(Integer posztId);
}

