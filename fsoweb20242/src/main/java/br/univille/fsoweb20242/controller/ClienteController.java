package br.univille.fsoweb20242.controller;

import java.util.HashMap;

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
    public ModelAndView visualizar(){
        var cliente = service.getAll();
        HashMap<String,Object> meuCliente = new HashMap<>();
        meuCliente.put("meuCliente", cliente);
        return new ModelAndView("cliente/perfil",meuCliente);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var cliente = new Cliente();
        HashMap<String,Object> dado = new HashMap<>();
        dado.put("cliente", cliente);
        return new ModelAndView("cadastro/cadastro",dado);
    }

    @PostMapping
    public ModelAndView salvar(Cliente cliente){
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