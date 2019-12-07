package pl.sullag.caretakerapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sullag.caretakerapp.UserDTO;

import javax.validation.Valid;

@Controller
public class SignUpAndLoginController {

    @RequestMapping("/login")
    public String showLoginPage() {
        return "loginPage";
    }

    @GetMapping("/register")
    public String showRegistrationForm(UserDTO userDTO, Model model) {
        model.addAttribute("userDTO", userDTO);
        return "registrationForm";
    }

    @PostMapping("/register")
    public String validateRegistrationForm(@Valid UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registrationForm";
        }
        return "redirect:/login";
    }
}



