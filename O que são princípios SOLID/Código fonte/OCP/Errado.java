import java.util.Scanner;

class PagamentoFuncionario {

    private double calcularTaxas(double salario) {
        System.out.println("Calcular taxas, e descontar do salário");
        return salario * 0.8;
    }

    public void pagarSalarioFuncionario(double salario) {
        System.out.println("Pagar salário CLT:");
        salario = calcularTaxas(salario);
        System.out.println("Pagar salário descontando taxas: " + salario);
    }

    public void pagarBolsaEstagio(double salario) {
        System.out.println("Pagar bolsa estágio: " + salario);
    }
}

public class Errado {

    public static void realizarOperacao(int operacao) {
        PagamentoFuncionario pagamento = new PagamentoFuncionario();

        if (operacao == 1) {
            pagamento.pagarSalarioFuncionario(2000);
        } else if (operacao == 2) {
            pagamento.pagarBolsaEstagio(1000);
        } else {
            throw new RuntimeException("Operação inválida");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Classe pagamento funcionário");
        System.out.println("Selecione uma operação:\n");
        System.out.println("1-Pagar salário funcionário");
        System.out.println("2-Pagar bolsa estágio");

        int operacao = sc.nextInt();
        sc.close();
        
        realizarOperacao(operacao);
    }
}
