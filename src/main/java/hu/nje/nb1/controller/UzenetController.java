package hu.nje.nb1.controller;

import hu.nje.nb1.service.UzenetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UzenetController {

    private final UzenetService uzenetService;

    public UzenetController(UzenetService uzenetService) {
        this.uzenetService = uzenetService;
    }

    @GetMapping("/uzenetek")
    public String listUzenetek(Model model) {
        model.addAttribute("uzenetek", uzenetService.getAllMessagesOrderByDateDesc());
        return "uzenetek";
    }
}
