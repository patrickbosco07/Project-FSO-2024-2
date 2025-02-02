package br.univille.fsoweb20242.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.univille.fsoweb20242.entity.Cliente;
import br.univille.fsoweb20242.repository.ClienteRepository;
import br.univille.fsoweb20242.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        cliente.setSenha(this.bCryptPasswordEncoder.encode(cliente.getSenha()));
        repository.save(cliente);
        return cliente;
    }

    @Override
    public Cliente delete(long id) {
        return null;
    }

    @Override
    public Cliente getById(long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent()){
            return retorno.get();
        }
        return null;
    }
    
    @Override
    public Cliente logar(long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent()){
            return retorno.get();
        }
        return null;
    }

    @Override
    public Cliente update(Cliente cliente) {
        var retorno = repository.findById(cliente.getId());
        if (retorno.isPresent()) {
            cliente.setSenha(this.bCryptPasswordEncoder.encode(cliente.getSenha()));
            repository.save(cliente);
            return cliente;
        }
        return null;
    }
    
}
