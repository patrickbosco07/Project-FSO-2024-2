package br.univille.fsoweb20242.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.univille.fsoweb20242.entity.Chamado;
import br.univille.fsoweb20242.repository.ChamadoRepository;
import br.univille.fsoweb20242.service.ChamadoService;

public class ChamadoServiceImpl implements ChamadoService{

    @Autowired
    ChamadoRepository chamadoRepository;

    @Override
    public List<Chamado> getAll() {
        var listaChamados = chamadoRepository.findAll();
        return listaChamados;
    }

    @Override
    public Chamado save(Chamado chamado) {
        chamadoRepository.save(chamado);
        return chamado;
    }

    @Override
    public Chamado delete(long Id) {
        var retorno = chamadoRepository.findById(Id);
        if(retorno.isPresent()){
            chamadoRepository.deleteById(Id);
            return retorno.get();
        }
        return null;
    }

    @Override
    public Chamado getById(long Id) {
        var retorno = chamadoRepository.findById(Id);
        if(retorno.isPresent()){
            return retorno.get();
        }
        return null;
    }
    
}
