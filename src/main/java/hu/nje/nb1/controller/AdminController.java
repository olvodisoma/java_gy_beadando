package hu.nje.nb1.controller;

import hu.nje.nb1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    // Admin főoldal – felhasználók listája
    @GetMapping
    public String adminPage(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin-users";
    }

    // Felhasználó törlése (csak non-admin)
    @GetMapping("/torol/{id}")
    public String torol(@PathVariable Long id, Model model) {
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            model.addAttribute("hiba", e.getMessage());
            model.addAttribute("users", userService.findAll());
            return "admin-users";
        }

        return "redirect:/admin";
    }
}
