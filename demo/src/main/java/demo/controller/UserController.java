package demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.repo.UserRepo;
import demo.model.User;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepository;
    
    @GetMapping("/users")
    public String getAllUsers(Model model) throws Exception {
        List<User> users = userRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String jsonUsers = mapper.writeValueAsString(users); 
        model.addAttribute("jsonUsers", jsonUsers);
        return "users"; 
    }
}
