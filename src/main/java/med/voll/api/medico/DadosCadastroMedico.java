package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank //não pode ser nulo, também, não pode ser vazio: precisa de um texto
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //4 a 6 dígitos.esclarecer, passaremos a expressão regular
        String crm,
        @NotNull //é un ENUM que não pode ser nulo/ @NotBlank somente para String
        Especialidade especialidade,
      @NotNull @Valid DadosEndereco endereco) //@NotNull endereço não pode ser nulo, e @Valid, para validar o DTO
     {
  }
