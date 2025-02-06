import java.time.LocalDate;


public class Pessoa {
    // atributos
    protected String nome;
    protected LocalDate dataNascimento;

    // inicializando o objeto
    public Pessoa(String nome, LocalDate dataNascimento)  {
        this.nome = nome;  // this nome se refere a ao atributo e nome refere-se ao construtor
        this.dataNascimento = dataNascimento;

    }

    // get para atributo 'nome'
    public String getNome() {
        return nome;
    }

    // get para atributo 'dataNascimento'
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }


}



