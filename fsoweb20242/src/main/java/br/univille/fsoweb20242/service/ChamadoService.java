package br.univille.fsoweb20242.service;

import java.util.List;

import br.univille.fsoweb20242.entity.Chamado;

public interface ChamadoService {
    
    List<Chamado>getAll();
    Chamado save(Chamado chamado);
    Chamado delete(long Id);
    Chamado getById(long Id);
}
