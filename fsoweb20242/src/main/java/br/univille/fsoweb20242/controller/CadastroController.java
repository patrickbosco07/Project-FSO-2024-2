package br.univille.fsoweb20242.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/cadastro")
public class CadastroController {
    
    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("cadastro/cadastro");
    }
    
}
