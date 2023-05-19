package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEnderecoPaciente(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        String complemento,
        String numero)
     {
}
