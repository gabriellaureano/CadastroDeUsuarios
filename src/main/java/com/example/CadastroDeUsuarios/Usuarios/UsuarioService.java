package com.example.CadastroDeUsuarios.Usuarios;

import lombok.Data;
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

    public UsuarioModel cadastrarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioModel> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public UsuarioModel buscarPorId(long id){
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuario não encontrado") );
    }

    public UsuarioModel atualizar(long id,UsuarioModel usuarioAtualizado){
        UsuarioModel usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        usuarioExistente.setSenha(usuarioAtualizado.getSenha());

        return usuarioRepository.save(usuarioExistente);
    }

    public void deletar(long id){
        UsuarioModel usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        usuarioRepository.delete(usuarioExistente);
    }
}
