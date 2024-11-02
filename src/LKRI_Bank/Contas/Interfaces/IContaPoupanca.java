package LKRI_Bank.Contas.Interfaces;

public interface IContaPoupanca {
    /**
     * Pagamento: Retira o valor Desejado da CP para a CC
     * retornara: Booleano para comfirmação de sucesso
     */
    Boolean Saque(Double Valor, Long senha);

    /**
     * Deposito: Retira o valor Desejado da  CP para a CC
     */
    Boolean Deposito(Double Valor, Long senha);
}
