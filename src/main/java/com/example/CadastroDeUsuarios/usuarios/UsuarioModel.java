package com.example.CadastroDeUsuarios.usuarios;

import com.example.CadastroDeUsuarios.tarefas.TarefasModel;
import jakarta.persistence.*;
import lombok.*;


// Entity ele transforma uma classe em uma entidade do banco de dados
@Data
@Entity
@Table(name = "tb_cadastro")
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    // @ManyToOne um usuario tem uma unica tarefa
    @ManyToOne
    @JoinColumn(name = "tarefa_id") // foreing key ou chave estrangeira
    private TarefasModel tarefa;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }
}
