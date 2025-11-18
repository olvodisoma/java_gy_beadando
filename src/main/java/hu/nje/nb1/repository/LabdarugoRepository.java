package hu.nje.nb1.repository;

import hu.nje.nb1.model.Labdarugo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabdarugoRepository extends JpaRepository<Labdarugo, Integer> {
long countByPoszt_Id(Integer posztId);
}

