package com.algafood.domain.service;

import com.algafood.domain.exception.EntidadeEmUsoException;
import com.algafood.domain.exception.GrupoNaoEncontradaException;
import com.algafood.domain.exception.NegocioException;
import com.algafood.domain.exception.UsuarioNaoEncontradaException;
import com.algafood.domain.model.Usuario;
import com.algafood.domain.repository.RestauranteRepository;
import com.algafood.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CadastroUsuarioService {
    public static final String NAO_COINCIDE_COM_A_SENHA_DO_USUARIO = "Senha atual informada não coincide com a senha do usuário.";

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Transactional
    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void alterarSenha(Long usuarioId, String senhaAtual, String novaSenha){
        Usuario usuario = buscarUsuarioOuFalhar(usuarioId);

        if (usuario.senhaNaoCoincideCom(senhaAtual)){
            throw new NegocioException(NAO_COINCIDE_COM_A_SENHA_DO_USUARIO);
        }
        usuario.setSenha(novaSenha);
    }

    public Usuario buscarUsuarioOuFalhar(Long usuarioId){
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNaoEncontradaException(usuarioId));
    }
}
