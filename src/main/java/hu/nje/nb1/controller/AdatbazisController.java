package hu.nje.nb1.controller;

import hu.nje.nb1.repository.KlubRepository;
import hu.nje.nb1.repository.PosztRepository;
import hu.nje.nb1.repository.LabdarugoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdatbazisController {

    private final LabdarugoRepository labdarugoRepository;
    private final KlubRepository klubRepository;
    private final PosztRepository posztRepository;

    public AdatbazisController(LabdarugoRepository labdarugoRepository,
                               KlubRepository klubRepository,
                               PosztRepository posztRepository) {

        this.labdarugoRepository = labdarugoRepository;
        this.klubRepository = klubRepository;
        this.posztRepository = posztRepository;
    }

    @GetMapping("/adatbazis")
    public String adatbazis(Model model) {

        model.addAttribute("jatekosok", labdarugoRepository.findAll());
        model.addAttribute("klubok", klubRepository.findAll());
        model.addAttribute("posztok", posztRepository.findAll());

        return "adatbazis";
    }

    @GetMapping("/jatekosok")
    public String jatekosok(Model model) {
        model.addAttribute("jatekosok", labdarugoRepository.findAll());
        return "jatekosok";
    }

    @GetMapping("/csapatok")
    public String csapatok(Model model) {
        model.addAttribute("klubok", klubRepository.findAll());
        return "csapatok";
    }
}
