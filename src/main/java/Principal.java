import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Principal {
    public static void main(String [] args) {
        // criando os funcionários
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000,10,18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990,5,12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961,5,2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988,10,14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995,1,5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999,11,19), new BigDecimal("1585.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993,3,31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994,7,8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(1993,5,24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(1996,9,2), new BigDecimal("2799.93"), "Gerente"));

        // Definindo o formato para a data: "dia/mês/ano"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNome().equals("Miguel")) {
                funcionarios.remove(i);
                break;
            }

        }

        // printar na tela a tabela de funcionario sem o nome Miguel

        for (int i = 0; i < funcionarios.size(); i++) {

            // para acessar o funcionário na posição
            Funcionario funcionario = funcionarios.get(i); // Acessando o funcionário na posição

            // Formatando a data para o formato desejado
            String dataFormatada = funcionario.getDataNascimento().format(formatter);

            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Data Nascimento: " + dataFormatada);
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("Função: " + funcionario.getFuncao());

        }

        for (int i = 0; i < funcionarios.size(); i++) {
            // para acessar o funcionário na posição
            Funcionario funcionario = funcionarios.get(i);

            // fazendo o aumento do salário
            BigDecimal salarioAumento = funcionario.getSalario().multiply(new BigDecimal("1.1"));


            // Formatando a data para o formato desejado
            String dataFormatada = funcionario.getDataNascimento().format(formatter);

            // mostrando a tabela atualizada com aumento do salário
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Data Nascimento: " + dataFormatada);
            System.out.println("Salário: " + salarioAumento);
            System.out.println("Função: " + funcionario.getFuncao());

        }

        // Agrupando funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();

        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario funcionario = funcionarios.get(i); // Acessando o funcionário na posição
            String funcao = funcionario.getFuncao(); // Obtendo a função do funcionário

            // Se a chave (função) não existe no mapa, cria uma nova lista
            if (!funcionariosPorFuncao.containsKey(funcao)) {
                funcionariosPorFuncao.put(funcao, new ArrayList<>());
            }

            // Adiciona o funcionário à lista correspondente à função
            funcionariosPorFuncao.get(funcao).add(funcionario);
        }

        // Iterando sobre as funções usando o for-each
        for (String funcao : funcionariosPorFuncao.keySet()) {
            List<Funcionario> listaFuncionarios = funcionariosPorFuncao.get(funcao);

            System.out.println("Função: " + funcao);

            //  este trecho de codigo corresponde 94 a linha 106
            // Iterando sobre os funcionários de cada função
            for (Funcionario funcionario : listaFuncionarios) {
                int mesNascimento = funcionario.getDataNascimento().getMonthValue(); // Obtém o mês da data de nascimento

                // fazendo a verificação de quem faz  aniversário neste mês
                if (mesNascimento == 10 || mesNascimento == 12) { // Verifica se é outubro (10) ou dezembro (12)
                    System.out.println("Nome: " + funcionario.getNome());
                    System.out.println("Data Nascimento: " + funcionario.getDataNascimento().format(formatter));
                    System.out.println("Função: " + funcionario.getFuncao());
                    System.out.println("Salário: " + funcionario.getSalario());
                    System.out.println("-------------------------");
                }
            }

            }
        // para saber quem é o funcionário mais velho
        Funcionario funcionarioMaisVelho = null;
        for (Funcionario funcionario: funcionarios) {
            long idade =  ChronoUnit.YEARS.between(funcionario.getDataNascimento(), LocalDate.now());
            if (funcionarioMaisVelho == null || idade > ChronoUnit.YEARS.between(funcionarioMaisVelho.getDataNascimento(), LocalDate.now())) {
                funcionarioMaisVelho = funcionario;
            }
        }
        // Exibindo o funcionário mais velho (fora do loop de funções)
        if (funcionarioMaisVelho != null) {
            long idadeMaisVelho = ChronoUnit.YEARS.between(funcionarioMaisVelho.getDataNascimento(), LocalDate.now());
            System.out.println("Funcionário mais velho: " + funcionarioMaisVelho.getNome() + " com " + idadeMaisVelho + " anos.");
        }

        // Ordenando os funcionários por nome antes de exibir a lista final
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
        System.out.println("\nLista final de funcionários ordenada por nome:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Data Nascimento: " + funcionario.getDataNascimento().format(formatter));
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("Função: " + funcionario.getFuncao());
            System.out.println("-------------------------");
        }

        // soma total do salário
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario funcionario = funcionarios.get(i);
            totalSalarios = totalSalarios.add(funcionario.getSalario());

        }
        System.out.println("Soma dos salários: " + totalSalarios);

        BigDecimal salarioMinimo = new BigDecimal("1212.00"); // Valor do salário mínimo

        // Lista de funcionários, supondo que você tenha um método que retorna os salários
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario funcionario = funcionarios.get(i);

            // Dividindo o salário do funcionário pelo salário mínimo
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP); // Com 2 casas decimais e arredondando

            // Imprimindo quantos salários mínimos o funcionário ganha
            System.out.println(funcionario.getNome() + " ganha " + salariosMinimos + " salários mínimos.");
        }

        }

    }


