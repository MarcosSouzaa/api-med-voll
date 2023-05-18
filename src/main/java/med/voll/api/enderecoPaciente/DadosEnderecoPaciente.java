package med.voll.api.enderecoPaciente;

public record DadosEnderecoPaciente(
        String logradouro,
        String bairro,
        String cep,
        String cidade,
        String uf,
        String numero,
        String complemento
      )
    {
}
