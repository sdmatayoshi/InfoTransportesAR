package demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import demo.repo.UserRepo;
import demo.model.User;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepository;
    
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        try {
            List<User> users = userRepository.findAll();
            model.addAttribute("users", users); // Pasa la lista de usuarios al modelo
            return "users"; // Nombre de la vista Thymeleaf
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error en los logs para depuración
            return "error"; // Nombre de la vista de error en caso de excepción
        }
    }
}
