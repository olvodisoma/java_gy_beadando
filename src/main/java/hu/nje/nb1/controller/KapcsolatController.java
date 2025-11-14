package hu.nje.nb1.controller;

import hu.nje.nb1.model.Uzenet;
import hu.nje.nb1.repository.UzenetRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class KapcsolatController {

    private final UzenetRepository uzenetRepository;

    public KapcsolatController(UzenetRepository uzenetRepository) {
        this.uzenetRepository = uzenetRepository;
    }

    // Tiltsd le az 'id' bindolását (nem szerkesztünk, csak létrehozunk)
    @InitBinder("uzenetForm")
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
    }

    @GetMapping("/kapcsolat")
    public String kapcsolatForm(Model model,
                                @RequestParam(value = "siker", required = false) Boolean siker) {
        model.addAttribute("uzenetForm", new Uzenet());
        if (Boolean.TRUE.equals(siker)) {
            model.addAttribute("siker", true);
        }
        return "kapcsolat";
    }

    @PostMapping("/kapcsolat")
    public String kapcsolatKuldes(
            @Valid @ModelAttribute("uzenetForm") Uzenet uzenet,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "kapcsolat";
        }

        uzenetRepository.save(uzenet);

        return "redirect:/kapcsolat?siker=true";
    }
}
