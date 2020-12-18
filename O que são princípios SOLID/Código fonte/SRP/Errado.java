import java.util.Scanner;

class Impressora {

    public void selecionarOperacao() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Classe impressora");
        System.out.println("Selecione uma operação:\n");
        System.out.println("1-Imprimir");
        System.out.println("2-Digitalizar");
        System.out.println("3-Imprimir e digitalizar");

        int operacao = sc.nextInt();
        sc.close();

        imprimirEDigitalizarDocumento(operacao);
    }

    public void imprimirEDigitalizarDocumento(int operacao) {
        if (operacao == 1) {

            System.out.println("Imprimindo o documento...\nImpressão completa");

        } else if (operacao == 2) {

            System.out.println("Digitalizando o documento...\nigitalização completa");

        } else if (operacao == 3) {

            System.out.println("Imprimindo o documento...\nImpressão completa");
            System.out.println("Digitalizando o documento...\nigitalização completa");

        } else {

            System.out.println("Erro! Operação inválida");

        }
    }
}

public class Errado {
    public static void main(String[] args) {
        Impressora impressora = new Impressora();
        impressora.selecionarOperacao();
    }
}