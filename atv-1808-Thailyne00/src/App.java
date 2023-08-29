import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // declarar
        ContaBancaria conta;
        int numero,agencia;
        String senha,email,cpf;
        double saldo;

        // instanciar
        conta = new ContaBancaria();

        // inicializar
        System.out.println("Digite o numero da conta:");
        numero = scan.nextInt();
        System.out.println("Digite a agencia da conta: ");
        agencia = scan.nextInt();
        System.out.println("digite o saldo inicial da conta: ");
        saldo = scan.nextDouble();
        System.out.println("Digite o cpf do titular: ");
        cpf = scan.next();
        System.out.println("Digite a sua senha: ");
        senha = scan.next();

        conta.setNumero(numero);
        conta.setAgencia(agencia);
        conta.setCpf(cpf);
        conta.setSenha(senha);
        

        System.out.println("Dados da conta");
        System.out.println(conta.toString());

        System.out.println(conta.depositar(saldo));

        System.out.println("Dados da conta");
        System.out.println(conta.toString());

        System.out.println(conta.depositar(saldo));

        System.out.println("Dados da conta");
        System.out.println(conta.toString());

        

    }
}