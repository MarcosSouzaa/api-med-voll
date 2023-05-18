package med.voll.api.paciente;

import med.voll.api.enderecoPaciente.DadosEnderecoPaciente;

public record DadosCadastroPaciente(
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEnderecoPaciente endereco
      )
   {
}
