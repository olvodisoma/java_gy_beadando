package hu.nje.nb1.controller;

import hu.nje.nb1.model.Poszt;
import hu.nje.nb1.service.PosztService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/poszt")
public class PosztController {

    private final PosztService posztService;

    public PosztController(PosztService posztService) {
        this.posztService = posztService;
    }

    // --- READ: lista ---
    @GetMapping
    public String list(Model model) {
        model.addAttribute("posztok", posztService.findAll());
        return "poszt-list";
    }

    // --- CREATE: új poszt űrlap ---
    @GetMapping("/uj")
    public String ujPoszt(Model model) {
        model.addAttribute("poszt", new Poszt());
        return "poszt-form";
    }

    // --- CREATE/UPDATE: mentés ---
    @PostMapping("/mentes")
    public String save(@ModelAttribute("poszt") Poszt poszt) {
        posztService.save(poszt);
        return "redirect:/poszt";
    }

    // --- UPDATE: meglévő betöltése ---
    @GetMapping("/modosit/{id}")
    public String modosit(@PathVariable Integer id, Model model) {
        model.addAttribute("poszt", posztService.findById(id));
        return "poszt-form";
    }

    // --- DELETE ---
    @GetMapping("/torol/{id}")
    public String torol(@PathVariable Integer id) {
        posztService.delete(id);
        return "redirect:/poszt";
    }
}
