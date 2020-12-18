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
        double valorSacado = valor * 1.05;

        if (valorSacado <= this.saldo) {
            this.saldo -= valorSacado;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

}

public class Certo {
    public static void main(String[] args) {
        ContaBanco contaCorrente = new ContaBanco(1000.0);
        ContaBanco contaBancoDigital = new ContaBancoDigital(1000.0);

        contaCorrente.saca(500);
        System.out.println("Salário conta corrente: " + contaCorrente.getSaldo());

        contaBancoDigital.saca(500);
        System.out.println("Salário conta banco digital: " + contaBancoDigital.getSaldo());
    }
}
