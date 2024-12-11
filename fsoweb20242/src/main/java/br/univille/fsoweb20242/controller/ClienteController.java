package br.univille.fsoweb20242.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.fsoweb20242.entity.Cliente;
import br.univille.fsoweb20242.repository.ClienteRepository;
import br.univille.fsoweb20242.service.ClienteService;

@Controller
@RequestMapping("/perfil")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ModelAndView index(){
        //chamar o banco de dados e fazer um select * from tabela
        var listaUsuario = service.getAll();
        //montar a tela com os dados banco
        return new ModelAndView("cliente/perfil",
                "listaUsuario",listaUsuario);
    }

    @PostMapping
    public ModelAndView novo(Cliente cliente){
        service.save(cliente);
        return new ModelAndView("redirect:/login");

    }
    
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umCliente = service.getById(id);
        return new ModelAndView("cliente/form",
                "cliente",umCliente);
    }



    
}