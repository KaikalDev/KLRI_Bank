package LKRI_Bank.Dados.interfaces;

import LKRI_Bank.Pessoa.Pessoa;

public interface IClientesMap {
    /**
     * Salva os Clientes
     */
    Boolean Cadastro(Pessoa cliente);

    /**
     * Possibilita a edição da senha
     */
    Boolean alterarSenha(Pessoa cliente, Long newSenha, Long senha);

    /**
     * Get para todos os dados de um cliente
     */
    Pessoa consultarDados(Long cpf, Long senha);
}
