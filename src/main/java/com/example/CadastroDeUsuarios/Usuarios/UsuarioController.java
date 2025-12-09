package com.example.CadastroDeUsuarios.Usuarios;

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
    public UsuarioModel cadastrarUsuario(@RequestBody UsuarioModel usuario){
        return usuarioService.cadastrarUsuario(usuario);
    }

    @GetMapping
    public List<UsuarioModel> listar(){
        return usuarioService.buscarTodos();
    }

    @GetMapping("/{id}") // @Pathvariable indica que o id sera o numero passado na url para prosseguir com o metodo
    public UsuarioModel buscarPorId(@PathVariable Long id){
        return usuarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public UsuarioModel atualizar(@PathVariable long id,@RequestBody UsuarioModel usuario){
        return usuarioService.atualizar(id,usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        usuarioService.deletar(id);
    }

}
