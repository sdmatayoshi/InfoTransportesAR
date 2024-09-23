package demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
            model.addAttribute("users", users); 
            return "users"; 
        } catch (Exception e) {
            e.printStackTrace(); 
            return "error"; 
        }
    }
    
   
    
    
    @GetMapping("/user/{id}")
    public String getUserById(Model model, @PathVariable long id) {
        try {
            Optional<User> userOptional = userRepository.findById((long) id);
            
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                model.addAttribute("user", user);
                return "user"; 
            } else {
                model.addAttribute("errorMessage", "Usuario no encontrado");
                return "error"; 
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Se produjo un error al obtener el usuario");
            return "error"; 
        }
    }
    @GetMapping("/user/edit/{id}")
    public String editUser(Model model, @PathVariable long id) {
        Optional<User> userOptional = userRepository.findById((long) id);
        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
            return "edit"; 
        }
        model.addAttribute("errorMessage", "Usuario no encontrado");
        return "error"; 
    }
    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userRepository.deleteById((long) id);
        return "redirect:/users"; 
    }

    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute User user) {
        userRepository.save(user); 
        return "redirect:/users"; 
    }

}
