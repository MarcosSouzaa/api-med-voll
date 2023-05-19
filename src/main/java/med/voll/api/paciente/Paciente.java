package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
import med.voll.api.endereco.EnderecoPaciente;

@Table(name = "pacientes")
@Entity(name="Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private EnderecoPaciente endereco;

    //Construtor para receber dados do paciente
    public Paciente(DadosCadastroPaciente dados) { //cheguei aqui com alt+enter vindo do PacienteController
       this.nome= dados.nome();
       this.email= dados.email();
       this.telefone= dados.telefone();
       this.cpf= dados.cpf();
       this.endereco = new EnderecoPaciente(dados.endereco());//lá na classe endereço eu crio como construtor que recebe como parâmetro, um dado endereço
    }
}
