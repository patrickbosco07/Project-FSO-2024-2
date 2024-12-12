package br.univille.fsoweb20242.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.fsoweb20242.entity.Cliente;
import br.univille.fsoweb20242.service.ClienteService;
import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("login/login");
    }

    @GetMapping("/autenticacao")
    public ModelAndView autenticacao(Model model) {
        List<Cliente> clientes = clienteService.getAll();
        return new ModelAndView("login/login","listaCliente",clientes);
    }

    @GetMapping("/checagem/{id}")    
    //@ResponseBody
    public ModelAndView login(@PathVariable("id") long id){
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
