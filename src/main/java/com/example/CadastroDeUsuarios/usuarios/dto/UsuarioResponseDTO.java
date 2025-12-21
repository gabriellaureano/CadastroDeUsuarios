package com.example.CadastroDeUsuarios.usuarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UsuarioResponseDTO {
    private Long id;

    @NotBlank(message = "Nome é obrigatorio!")
    private String nome;

    @NotBlank(message = "Email é obrigatorio!")
    @Email(message = "Email inválido!")
    private String email;

    public UsuarioResponseDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public UsuarioResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}
