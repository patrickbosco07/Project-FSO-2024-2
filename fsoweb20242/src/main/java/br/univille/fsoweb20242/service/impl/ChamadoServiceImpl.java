package br.univille.fsoweb20242.service.impl;

import java.util.List;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fsoweb20242.entity.Chamado;
import br.univille.fsoweb20242.repository.ChamadoRepository;
import br.univille.fsoweb20242.service.ChamadoService;

@Service
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

    @Override
    public boolean checkAttach(Chamado chamado) {
        var arquivoValido = true;
        var arquivo = chamado.getArquivo();
        Tika tika = new Tika();
        String mimeType = tika.detect(arquivo);
        if (arquivo.length > 1048576 && !mimeType.equals("image/png") && !mimeType.equals("image/jpeg")) {
            arquivoValido = false;
        }
        return arquivoValido;
    }
    
}
