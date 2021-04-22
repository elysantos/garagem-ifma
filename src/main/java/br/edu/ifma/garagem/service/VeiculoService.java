package br.edu.ifma.garagem.service;

import br.edu.ifma.garagem.mapper.VeiculoMapper;
import br.edu.ifma.garagem.model.Veiculo;
import br.edu.ifma.garagem.util.exceptions.BDException;
import br.edu.ifma.garagem.util.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoMapper veiculoMapper;

    public List<Veiculo> findByUsuario(int usuario) {
        return veiculoMapper.findAllByUsuario(usuario);
    }

    public Veiculo findOne(int idUsuario, int id) throws NotFoundException {
        Veiculo veiculo = veiculoMapper.findByUsuarioAndId(idUsuario, id);
        if(veiculo == null){
            throw new NotFoundException("Nada encontrado");
        }
        return veiculo;
    }

    public void inserir(int idUsuario, Veiculo veiculo) throws BDException {
        try{
            veiculoMapper.insert(veiculo, idUsuario);
        }catch (RuntimeException e){
            throw new BDException(e.getMessage());
        }
    }

    public void update(int idUsuario, int idVeiculo, Veiculo veiculo) throws NotFoundException, BDException {
        try{
            Veiculo veiculoAtual = veiculoMapper.findByUsuarioAndId(idUsuario, idVeiculo);
            if(veiculoAtual == null || veiculoAtual.getId() != veiculo.getId()){
                throw new NotFoundException("Não encontrado");
            }
            veiculoMapper.update(veiculo);
        }catch (RuntimeException e){
            throw new BDException(e.getMessage());
        }
    }

    public void delete(int idUsuario, int idVeiculo) throws NotFoundException, BDException {
        try{
            Veiculo veiculoAtual = veiculoMapper.findByUsuarioAndId(idUsuario, idVeiculo);
            if(veiculoAtual == null ){
                throw new NotFoundException("Não encontrado");
            }
            veiculoMapper.delete(idVeiculo);
        }catch (RuntimeException e){
            throw new BDException(e.getMessage());
        }
    }
}