import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;

    }

    // get para atributo 'salario'
    public BigDecimal getSalario() {
        return salario;
    }

    // get para atributo 'funcao'
    public String getFuncao() {
        return funcao;
    }



}
