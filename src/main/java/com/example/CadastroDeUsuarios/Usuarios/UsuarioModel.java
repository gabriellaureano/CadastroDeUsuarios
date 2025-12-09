package com.example.CadastroDeUsuarios.Usuarios;

import com.example.CadastroDeUsuarios.Tarefas.TarefasModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// Entity ele transforma uma classe em uma entidade do banco de dados
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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






}
