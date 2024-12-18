package br.univille.fsoweb20242.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.fsoweb20242.entity.Chamado;
import br.univille.fsoweb20242.service.ChamadoService;

@Controller
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    ChamadoService chamadoService;

    @GetMapping
    public ModelAndView index(){
        var listaChamados = chamadoService.getAll();
        //montar a tela com os dados banco
        return new ModelAndView("cliente/chamados",
                "listaChamados",listaChamados);
    }

    @GetMapping("/novo")
    public ModelAndView processar(Chamado chamado){
        chamadoService.save(chamado);
        return new ModelAndView("redirect:/chamados");
    }
    
}
