package com.example.CadastroDeUsuarios.usuarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class UsuarioCreateDTO {

    @NotBlank(message = "Nome é obrigatorio!")
    private String nome;

    @NotBlank(message = "Email é obrigatorio!")
    @Email(message = "Email inválido!")
    private String email;

    @NotBlank(message = "Senha é obrigatorio!")
    private String senha;

    public UsuarioCreateDTO(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public UsuarioCreateDTO() {
    }

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
}
