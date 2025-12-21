package com.example.CadastroDeUsuarios.tarefas;

import com.example.CadastroDeUsuarios.usuarios.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table (name = "tb_tarefas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TarefasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    // Uma tarefa pode ter varios usuarios
    @OneToMany(mappedBy = "tarefa")

    private List<UsuarioModel> usuarios;

}
