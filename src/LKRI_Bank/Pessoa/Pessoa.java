package LKRI_Bank.Pessoa;

import java.util.Objects;

public class Pessoa {
    private String Nome;
    private Integer idade;
    private Long cpf;
    private Long Senha;
    private Long NumeroConta;

    public Pessoa(String nome, Integer idade, String cpf, Long numeroConta, Long senha) {
        this.Nome = nome;
        this.idade = idade;
        setCpf(cpf);
        this.NumeroConta = numeroConta;
        this.Senha = senha;
    }

    public Boolean verificaSenha(Long senha) {
        return Objects.equals(senha, this.Senha);
    }

    public boolean setSenha(Long newSenha, Long Senha) {
        if (Objects.equals(this.Senha, Senha)) {
            this.Senha = newSenha;
            return true;
        }
        return false;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = Long.parseLong(cpf.replace(".","")
                .replace("-", ""));;
    }

    public Long getNumeroConta() {
        return NumeroConta;
    }

    public void setNumeroConta(Long numeroConta) {
        NumeroConta = numeroConta;
    }
}
