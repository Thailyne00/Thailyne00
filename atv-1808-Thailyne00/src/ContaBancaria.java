public class ContaBancaria {

    // atributo/caracteristicas
    private int numero;
    private int agencia;
    private double saldo;
    private String cpf;
    private String senha;
    private String email;

    public ContaBancaria(int numero,int agencia,double saldo,String cpf,String senha  ){

    this.numero = numero;
    this.agencia = agencia;
}
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void getnumero(int numero) {
        this.numero = numero;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void getAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void getCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void getsenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void getEmail(String email) {
        this.email = email;
    }

    boolean testarValor(double valor) {
        if (valor > 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean valorMenorOuIgualQueSaldo(double valor) {
        return valor <= saldo;
    }

    boolean valorValidoSaque(double valor) {
        boolean maiorQueZero = testarValor(valor);
        boolean menorQueSaldo = valorMenorOuIgualQueSaldo(valor);

        if (maiorQueZero && menorQueSaldo) {
            return true;
        } else {
            return false;
        }

    }

    // ações métodos funções
    public String sacar(double valor) {
        boolean teste = testarValor(valor);
        if (valorValidoSaque(valor)) {
            saldo = saldo - valor;
            return "Saque realizado";
        } else {
            return " Valor invalido";
        }

    }

    public String depositar(double valor) {
        saldo = saldo + valor;
        if (testarValor(valor)) {
            saldo = saldo + valor;
            return "Deposito Realizado";

        }
        return "Deposito reslizado";
    }

    public String toString() {
        return ("Numero " + numero + " Agencia: " + agencia + " Saldo: " + saldo + " Cpf: " + cpf + " Senha: " + senha);

    }

}
