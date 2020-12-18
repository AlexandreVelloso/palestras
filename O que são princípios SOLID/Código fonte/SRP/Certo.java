import java.util.Scanner;

class Impressora {
    public void digitalizar() {
        System.out.println("Digitalizando o documento...\nigitalização completa");
    }

    public void imprimir() {
        System.out.println("Imprimindo o documento...\nImpressão completa");
    }
}

public class Certo {

    public static void realizarOperacao(int operacao) {
        Impressora impressora = new Impressora();

        if (operacao == 1) {
            impressora.imprimir();
        } else if (operacao == 2) {
            impressora.digitalizar();
        } else if (operacao == 3) {
            impressora.digitalizar();
            impressora.imprimir();
        } else {
            throw new RuntimeException("Operação inválida");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Classe impressora");
        System.out.println("Selecione uma operação:\n");
        System.out.println("1-Imprimir");
        System.out.println("2-Digitalizar");
        System.out.println("3-Imprimir e digitalizar");

        int operacao = sc.nextInt();
        sc.close();

        realizarOperacao(operacao);
    }
}
