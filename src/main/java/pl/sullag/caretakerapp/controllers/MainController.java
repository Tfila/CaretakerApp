package pl.sullag.caretakerapp.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @RequestMapping({"/","/index","/index.html","/indexPage.html"})
    public String showIndexPage(){
        return "indexPage";
    }

    @RequestMapping({"/admin"})
    public String showAdminPage(){
        return "adminPage";
    }

}
