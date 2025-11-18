package hu.nje.nb1.service;

import hu.nje.nb1.model.Labdarugo;
import hu.nje.nb1.repository.LabdarugoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabdarugoService {

    private final LabdarugoRepository labdarugoRepository;

    public LabdarugoService(LabdarugoRepository labdarugoRepository) {
        this.labdarugoRepository = labdarugoRepository;
    }

    public List<Labdarugo> findAll() {
        return labdarugoRepository.findAll();
    }

    public Labdarugo findById(Integer id) {
        return labdarugoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nincs ilyen labdarúgó: " + id));
    }

    public void save(Labdarugo labdarugo) {
        labdarugoRepository.save(labdarugo);
    }

    public void delete(Integer id) {
        labdarugoRepository.deleteById(id);
    }
    public boolean existsById(Integer id) {
    return labdarugoRepository.existsById(id);
}
}
