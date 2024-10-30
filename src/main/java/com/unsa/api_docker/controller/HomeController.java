import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Bienvenido a la API de Pinturas"; // O puedes retornar una vista si tienes
    }
}
