package br.univille.fsoweb20242.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.fsoweb20242.service.ClienteService;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("login/login");
    }


    @GetMapping("/checagem")    
    //@ResponseBody
    public ModelAndView login(long id){
        ModelAndView modelAndView = new ModelAndView();
        var umCliente = clienteService.logar(id);
        if (umCliente != null) {
            // Redirecionar para a página inicial se a operação for concluída
            modelAndView.setViewName("redirect:/home");
        } else {
            // Permanecer na mesma página e exibir uma mensagem de erro
            modelAndView.setViewName("login/login");
            modelAndView.addObject("errorMessage", "Login incorreto!");
        }
        
        return modelAndView;
    }
}
