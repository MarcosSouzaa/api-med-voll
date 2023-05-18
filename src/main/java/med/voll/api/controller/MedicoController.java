package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    //Vamos declarar o repository como um atributo da classe MedicoController.
    @Autowired //injeção de dependência para estanciar o repository automático
    private MedicoRepository repository;
    @PostMapping
    @Transactional //transação ativa com banco de dados porque faremos insert etc.

    //@RequestBody informa ao Spring que é pra ele pegar o que está no corpo da requisição
    //@Valid, para solicitar que o Spring se integre ao Bean Validation e execute as validações
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){//recebendo um DTO em DadosCadastroMedico

        //como aqui é passado um DTO, vou precisar passar UM CONSTRUTOR
        repository.save(new Medico(dados)); //Faz o insert no banco de dados
    }
}
