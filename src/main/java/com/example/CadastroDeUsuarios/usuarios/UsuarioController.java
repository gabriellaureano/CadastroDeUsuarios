package com.example.CadastroDeUsuarios.usuarios;

import com.example.CadastroDeUsuarios.usuarios.dto.UsuarioCreateDTO;
import com.example.CadastroDeUsuarios.usuarios.dto.UsuarioResponseDTO;
import com.example.CadastroDeUsuarios.usuarios.dto.UsuarioUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping // o @RequestBody pega os dados json enviados no post e transforma no usuarioModel
    public UsuarioModel cadastrarUsuario(@Valid @RequestBody UsuarioCreateDTO usuario){
        return usuarioService.cadastrarUsuario(usuario);
    }

    @GetMapping
    public List<UsuarioResponseDTO> buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @GetMapping("/{id}") // @Pathvariable indica que o id sera o numero passado na url para prosseguir com o metodo
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id){
        return usuarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public UsuarioUpdateDTO atualizar(@PathVariable long id, @RequestBody UsuarioUpdateDTO usuario){
        return usuarioService.atualizar(id,usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        usuarioService.deletar(id);
    }

}
