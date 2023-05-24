package med.voll.api.medico;
    //volto para o método listar no MedicoController, mas encontrando erro, faço conversão com stream().map()
   public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade Especialidade ){
    //retorno aqui para criar esse construtor passando Medico medico
    // inclui um ID para o medico no DTO e no construtor
   public DadosListagemMedico(Medico medico){
      this(medico.getId(),medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
   }

}
