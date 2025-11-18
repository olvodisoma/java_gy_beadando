package hu.nje.nb1.controller;

import hu.nje.nb1.service.DiagramService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiagramController {

    private final DiagramService diagramService;

    public DiagramController(DiagramService diagramService) {
        this.diagramService = diagramService;
    }

    @GetMapping("/diagram")
    public String diagram(Model model) {
        model.addAttribute("labels", diagramService.getPosztNev());
        model.addAttribute("values", diagramService.getJatekosokSzamaPosztonkent());
        return "diagram";
    }
}
