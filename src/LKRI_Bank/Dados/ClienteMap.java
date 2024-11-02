package LKRI_Bank.Dados;

import LKRI_Bank.Dados.interfaces.IClientesMap;
import LKRI_Bank.Pessoa;

import java.util.HashMap;
import java.util.Map;

public class ClienteMap implements IClientesMap {

    private final Map<Long, Pessoa> map;

    public ClienteMap() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean Cadastro(Pessoa cliente) {
        if (this.map.containsKey(cliente.getCpf())) {
            return false; /* Erro de cliente exixtente */
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;

    }

    @Override
    public Boolean alterarSenha(Pessoa cliente, Long newSenha, Long senha) {
        Pessoa clienteOriginal = this.map.get(cliente.getCpf());

        if (clienteOriginal != null && clienteOriginal.verificaSenha(senha)) {
            clienteOriginal.setSenha(newSenha);
            return true; /* Erro de cliente inexistet e de senha invalida*/
        }
        return false;

    }

    @Override
    public Pessoa consultarDados(Long cpf, Long senha) {
        Pessoa cliente = this.map.get(cpf);

        if (cliente.verificaSenha(senha)) {
            return cliente; /* Erro de senha invalida*/
        }
        return null;
    }

}
