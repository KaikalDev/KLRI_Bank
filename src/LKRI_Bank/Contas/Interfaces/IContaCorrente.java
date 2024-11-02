package LKRI_Bank.Contas.Interfaces;

public interface IContaCorrente {
    /**
     * Pagamento: Retira o valor Desejado do saldo
     * retornara: Booleano para comfirmação de sucesso
     */
    Boolean Pagamento(Double valor, Long senha);

    /**
     * Deposito: Adiciona o valor Desejado do saldo
     */
    void Deposito(Double valor);

    /**
     * Rendimento: A cada mes é aplicado 0,05% a cada 100R$ poupado
     */
    Object[][] SimularRendimnto(Integer totalMeses);
}
