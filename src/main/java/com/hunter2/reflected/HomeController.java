package hunter2.reflected;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

  @ModelAttribute
  public void setVaryResponseHeader(HttpServletResponse response) {
    response.setHeader("X-XSS-Protection", "0");
  }

  @GetMapping("/")
  public String homeForm(Model model) {
    model.addAttribute("input", new UserInput());
    return "home";
  }

  @PostMapping("/")
  public String homeResult(@ModelAttribute("input") UserInput input) {
    return "result";
  }

}