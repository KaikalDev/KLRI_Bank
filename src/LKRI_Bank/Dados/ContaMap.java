package LKRI_Bank.Dados;

import LKRI_Bank.Contas.ContaCorrente;
import LKRI_Bank.Dados.interfaces.IContaMap;

import java.util.HashMap;
import java.util.Map;

public class ContaMap implements IContaMap {

    private final Map<Long, ContaCorrente> map;

    public ContaMap() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean Cadastro(ContaCorrente cc) {
        if (this.map.containsKey(cc.getNumeroConta())) {
            return false; /* Erro de Conta ja existente */
        }
        this.map.put(cc.getNumeroConta(), cc);
        return true;
    }

    @Override
    public ContaCorrente consultarDados(Long NumeroConta) {
        /* Erro de Conta inexistet */
        return this.map.get(NumeroConta);
    }
}
