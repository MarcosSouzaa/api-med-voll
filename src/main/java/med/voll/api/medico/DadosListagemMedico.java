package med.voll.api.medico;
//volto para o método listar no MedicoController, mas encontrando erro, faço conversão com stream().map()
public record DadosListagemMedico(String nome, String email, String crm, Especialidade Especialidade ){
//retorno aqui para criar esse construtor passando Medico medico
   public DadosListagemMedico(Medico medico){
      this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
   }
}
