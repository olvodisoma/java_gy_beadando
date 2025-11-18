package hu.nje.nb1.service;

import hu.nje.nb1.model.Poszt;
import hu.nje.nb1.repository.PosztRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosztService {

    private final PosztRepository posztRepository;

    public PosztService(PosztRepository posztRepository) {
        this.posztRepository = posztRepository;
    }

    public List<Poszt> findAll() {
        return posztRepository.findAll();
    }

    public Poszt findById(Integer id) {
        return posztRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nincs ilyen poszt: " + id));
    }

    public void save(Poszt poszt) {
        posztRepository.save(poszt);
    }

    public void delete(Integer id) {
        posztRepository.deleteById(id);
    }
}
