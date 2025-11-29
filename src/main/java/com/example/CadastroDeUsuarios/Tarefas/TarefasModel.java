package com.example.CadastroDeUsuarios.Tarefas;

import com.example.CadastroDeUsuarios.Usuarios.UsuarioModel;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table (name = "tb_tarefas")
public class TarefasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    // Uma tarefa pode ter varios usuarios
    @OneToMany(mappedBy = "tarefas")

    private List<UsuarioModel> usuarios;

    public TarefasModel(){

    }

    public TarefasModel(String nome, String dificuldade) {
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
