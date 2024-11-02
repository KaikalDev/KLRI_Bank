package LKRI_Bank.Contas;

import LKRI_Bank.Dados.ContaMap;
import LKRI_Bank.Dados.interfaces.IContaMap;
import LKRI_Bank.Contas.Interfaces.IContaPoupanca;
import LKRI_Bank.Pessoa.Pessoa;

public class ContaPoupanca implements IContaPoupanca {
    private Double Saldo;
    private Pessoa Titular;
    private Long NumeroConta;

    public static IContaMap contaMap = new ContaMap();

    public ContaPoupanca(Double saldo, Pessoa titular, Long numeroConta) {
        Saldo = saldo;
        Titular = titular;
        NumeroConta = numeroConta;
    }

    @Override
    public Boolean Saque(Double valor, Long senha) {
        ContaCorrente cc = contaMap.consultarDados(NumeroConta);
        if (valor < Saldo) {
            /* Erro saldo insuficiente */
            this.Saldo -= valor;
            cc.Deposito(valor);
            return true;
        }
        return false;
    }

    @Override
    public Boolean Deposito(Double valor, Long senha) {
        ContaCorrente cc = contaMap.consultarDados(NumeroConta);
        Boolean retorno = cc.Pagamento(valor,senha);
        if (retorno) {
            this.Saldo += valor;
        }
        return retorno;
    }
}
