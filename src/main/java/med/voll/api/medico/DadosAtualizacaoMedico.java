package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        //Id é obrigatório. Não pode ser notBlank porque não é uma String
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {

    }

