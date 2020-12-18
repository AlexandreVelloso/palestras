class ContaBanco {

    protected double saldo;

    public ContaBanco(double saldo) {
        this.saldo = saldo;
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }

    public void saca(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

    public double getSaldo() {
        return this.saldo;
    }
}

class ContaBancoDigital extends ContaBanco {

    public ContaBancoDigital(double saldo) {
        super(saldo);
    }

    public void saca(double valor) {
        // Gera uma exception diferente da classe pai
        throw new RuntimeException("Método não implementado");
    }

}

public class Errado {
    public static void main(String[] args) {
        ContaBanco contaCorrente = new ContaBanco(1000.0);
        ContaBanco contaBancoDigital = new ContaBancoDigital(1000.0);

        contaCorrente.saca(500);
        System.out.println("Salário conta corrente: " + contaCorrente.getSaldo());

        // Gera exception
        contaBancoDigital.saca(500);
        System.out.println("Salário conta banco digital: " + contaBancoDigital.getSaldo());
    }
}
