package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.DadosEnderecoPaciente;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoPaciente {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public EnderecoPaciente(DadosEnderecoPaciente dados) { //vou trocar o endereço paciente por dados para ficar mais legível
            this.logradouro = dados.logradouro();
            this.numero = dados.numero();
            this.complemento = dados.complemento();
            this.bairro = dados.bairro();
            this.cidade = dados.cidade();
            this.uf = dados.uf();
            this.cep = dados.cep();
        }
    }

