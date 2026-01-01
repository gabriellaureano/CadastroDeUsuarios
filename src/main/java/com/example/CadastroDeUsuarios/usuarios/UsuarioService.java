package com.example.CadastroDeUsuarios.usuarios;

import com.example.CadastroDeUsuarios.exception.UsuarioNaoEncontradoException;
import com.example.CadastroDeUsuarios.usuarios.dto.UsuarioCreateDTO;
import com.example.CadastroDeUsuarios.usuarios.dto.UsuarioResponseDTO;
import com.example.CadastroDeUsuarios.usuarios.dto.UsuarioUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioModel cadastrarUsuario(UsuarioCreateDTO usuarioCreateDTO){
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(usuarioCreateDTO.getNome());
        usuario.setEmail(usuarioCreateDTO.getEmail());
        usuario.setSenha(usuarioCreateDTO.getSenha());

        return usuarioRepository.save(usuario);
    }

    public List<UsuarioResponseDTO> buscarTodos(){

        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> new UsuarioResponseDTO(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail()
                ))
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(long id){
        UsuarioModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }

    public UsuarioUpdateDTO atualizar(long id, UsuarioUpdateDTO usuarioUpdateDTO){
        UsuarioModel usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));

        usuarioExistente.setNome(usuarioUpdateDTO.getNome());
        usuarioExistente.setEmail(usuarioUpdateDTO.getEmail());

        UsuarioModel usuarioAtualizado = usuarioRepository.save(usuarioExistente);

        return new UsuarioUpdateDTO(
                usuarioAtualizado.getNome(),
                usuarioAtualizado.getEmail()
        );
    }

    public void deletar(long id){
        UsuarioModel usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));

        usuarioRepository.delete(usuarioExistente);
    }
}
