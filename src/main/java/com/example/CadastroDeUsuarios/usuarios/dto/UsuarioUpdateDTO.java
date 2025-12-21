package com.example.CadastroDeUsuarios.usuarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioUpdateDTO {
    @NotBlank(message = "Nome é obrigatorio!")
    private String nome;

    @NotBlank(message = "Email é obrigatorio!")
    @Email
    private String email;

    public UsuarioUpdateDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
