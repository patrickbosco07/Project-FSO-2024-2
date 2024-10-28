package br.univille.fsoweb20242.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.fsoweb20242.entity.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado,Long> {
    
}
