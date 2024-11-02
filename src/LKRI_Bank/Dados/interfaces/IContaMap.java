package LKRI_Bank.Dados.interfaces;

import LKRI_Bank.Contas.ContaCorrente;

public interface IContaMap {
    /**
     * Salva a Conta
     */
    Boolean Cadastro(ContaCorrente cc);

    /**
     * Get para todos os dados de uma Conta
     */
    ContaCorrente consultarDados(Long NumeroConta);
}
