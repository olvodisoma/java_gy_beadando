package hu.nje.nb1.service;

import hu.nje.nb1.model.Uzenet;
import hu.nje.nb1.repository.UzenetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UzenetService {

    private final UzenetRepository uzenetRepository;

    public UzenetService(UzenetRepository uzenetRepository) {
        this.uzenetRepository = uzenetRepository;
    }

    public List<Uzenet> getAllMessagesOrderByDateDesc() {
        return uzenetRepository.findAllByOrderByKuldesIdejeDesc();
    }
}