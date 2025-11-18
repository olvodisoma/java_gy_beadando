package hu.nje.nb1.service;

import hu.nje.nb1.repository.PosztRepository;
import hu.nje.nb1.repository.LabdarugoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiagramService {

    private final PosztRepository posztRepository;
    private final LabdarugoRepository labdarugoRepository;

    public DiagramService(PosztRepository posztRepository, LabdarugoRepository labdarugoRepository) {
        this.posztRepository = posztRepository;
        this.labdarugoRepository = labdarugoRepository;
    }

    // Posztok nevei
    public List<String> getPosztNev() {
        return posztRepository.findAll()
                .stream()
                .map(poszt -> poszt.getNev())
                .collect(Collectors.toList());
    }

    // Hány játékos tartozik egy posztra
    public List<Long> getJatekosokSzamaPosztonkent() {
        return posztRepository.findAll()
                .stream()
                .map(poszt -> labdarugoRepository.countByPoszt_Id(poszt.getId()))
                .collect(Collectors.toList());
    }
}
