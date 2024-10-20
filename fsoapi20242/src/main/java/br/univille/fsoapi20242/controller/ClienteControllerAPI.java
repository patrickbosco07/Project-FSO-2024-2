package br.univille.fsoapi20242.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.fsoapi20242.entity.Cliente;
import br.univille.fsoapi20242.service.ClienteService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteControllerAPI {
    
    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes(){
        var listaClientes = service.getAll();

        return new ResponseEntity<List<Cliente>>
                    (listaClientes,HttpStatus.OK);
    }

    @PutMapping("path/{id}")
    public ResponseEntity<Cliente> putCliente(@PathVariable long id, @RequestBody Cliente cliente) {
        
        var clienteAntigo = service.getById(id);
        if(clienteAntigo == null){
            return ResponseEntity.notFound().build();
        }

        clienteAntigo.setNome(cliente.getNome());
        clienteAntigo.setEndereco(cliente.getEndereco());
        clienteAntigo.setDataNascimento(cliente.getDataNascimento());
        
        service.save(clienteAntigo);

        return new ResponseEntity<Cliente>(clienteAntigo, HttpStatus.OK);
    }
}
