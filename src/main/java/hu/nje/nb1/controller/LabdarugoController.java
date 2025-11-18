package hu.nje.nb1.controller;

import hu.nje.nb1.model.Labdarugo;
import hu.nje.nb1.service.LabdarugoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/labdarugok")
public class LabdarugoController {

    private final LabdarugoService labdarugoService;

    public LabdarugoController(LabdarugoService labdarugoService) {
        this.labdarugoService = labdarugoService;
    }

    // READ – lista
    @GetMapping
    public String list(Model model) {
        model.addAttribute("labdarugok", labdarugoService.findAll());
        return "labdarugo-list";
    }

    // CREATE – új játékos űrlap
    @GetMapping("/uj")
    public String uj(Model model) {
        model.addAttribute("labdarugo", new Labdarugo());
        model.addAttribute("modositas", false);
        return "labdarugo-form";
    }


    // CREATE/UPDATE – mentés
        @PostMapping("/mentes")
        public String save(@ModelAttribute("labdarugo") Labdarugo labdarugo,
                        @RequestParam(value = "modositas", required = false) Boolean modositas,
                        Model model) {

            boolean editing = Boolean.TRUE.equals(modositas);
            boolean exists = labdarugoService.existsById(labdarugo.getId());

            // ÚJ rekordnál ellenőrizzük, hogy foglalt-e az ID
            if (!editing && exists) {
                model.addAttribute("hiba", "A megadott ID már létezik!");
                return "labdarugo-form";
            }

            labdarugoService.save(labdarugo);
            return "redirect:/labdarugok";
        }

    // UPDATE – meglévő betöltése
    @GetMapping("/modosit/{id}")
    public String modosit(@PathVariable Integer id, Model model) {
        model.addAttribute("labdarugo", labdarugoService.findById(id));
        model.addAttribute("modositas", true);
        return "labdarugo-form";
    }
    // DELETE
    @GetMapping("/torol/{id}")
    public String torol(@PathVariable Integer id) {
        labdarugoService.delete(id);
        return "redirect:/labdarugok";
    }
}
