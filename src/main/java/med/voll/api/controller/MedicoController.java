package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    //vou criar um DTO para devolver uma listagem de médicos
    //Não posso devolver a lista de Médicos porque ele devolverá dados além que preciso
    //se não for informado o padrão de paginação, carregue como abaixo: carregue 10 registros ordenado pelo nome
    @GetMapping
    public Page<DadosListagemMedico>listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){

        //repository para acessar o banco
        //tenho que fazer uma conversão de Medico para  DadosListagemMedico
        //daqui, preciso retornar nesse DTO e fazer um construtor para esse new
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }
    @Transactional
    //método para atualização
    //como vou fazer alterações no banco de dados, preciso do @Transactional
    @PutMapping
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        //vou no banco de dados com repository e o método getReferenceById  e buscar a referencia que
        // atualizar pelo id que está dentro do DTO E GUARDAR DENTRO DE UMA VARIÁVEL
      var medico = repository.getReferenceById(dados.id());
      medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();

    }

}
