package LKRI_Bank.Contas;

import LKRI_Bank.Contas.Interfaces.IContaCorrente;
import LKRI_Bank.Pessoa.Pessoa;

public class ContaCorrente implements IContaCorrente {
    private Double Saldo;
    private Pessoa Titular;
    private Long NumeroConta;
    private ContaPoupanca Poupanca;

    public ContaCorrente(Double saldo, Pessoa titular, Long numeroConta) {
        Saldo = 0.00;
        Titular = titular;
        NumeroConta = numeroConta;
        Poupanca = new ContaPoupanca(0.00, titular, numeroConta);
    }

    public Double getSaldo() {
        return Saldo;
    }

    public Pessoa getTitular() {
        return Titular;
    }

    public Long getNumeroConta() {
        return NumeroConta;
    }

    public void setSaldo(Double saldo) {
        Saldo = saldo;
    }

    @Override
    public Boolean Pagamento(Double valor, Long senha) {
        if (Titular.verificaSenha(senha) && valor < Saldo) {
            /* Erro saldo insuficiente e senha incorreta */
            this.Saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public void Deposito(Double valor) {
        this.Saldo += valor;
    }

    @Override
    public Object[][] SimularRendimnto(Integer totalMeses) {
        if (totalMeses <= 12 && Saldo >= 100) {
            /* Erro o maximo é 12 meses */
            /* Info do saldo < 100 */
            Object[][] matriz = new Object[totalMeses][2];
            Double saldoSimulacao = this.getSaldo();
            double rendimento = 0.00;

            for (int mes = 1; mes <= totalMeses; mes++) {
                if (saldoSimulacao > 100) {
                    rendimento += (saldoSimulacao / 100) * 0.05;
                    saldoSimulacao += rendimento;
                }
                matriz[mes][0] = mes;
                matriz[mes][1] = saldoSimulacao;
            }

            return matriz;
        }
        return null;
    }

}
