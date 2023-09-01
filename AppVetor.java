import java.util.Scanner;

import javax.swing.text.html.parser.ContentModel;

public class App {
    private static Scanner scan;

    private static String menu() {
        String str = "";
        str += "1 - Cadastrar Pessoa\n";
        str += "2 - Visualizar Pessoa\n";
        str += "3 - Cadastrar Conta Bancaria\n";
        str += "4 - Visualizar Conta Bancaria\n";
        str += "5 - Depositar Conta Bancaria\n";
        str += "6 - Sacar Conta Bancaria\n";

        str += "0 - Sair\n";

        return str;
    }

    private static Pessoa cadastrarPessoa() {
        String nome, cpf, email, telefone;
        Pessoa pessoa;

        System.out.println("###Cadastro de Pessoa###");
        System.out.println("Digite o nome:");
        nome = scan.nextLine();
        System.out.println("Digite o cpf:");
        cpf = scan.nextLine();
        System.out.println("Digite o e-mail:");
        email = scan.nextLine();
        System.out.println("Digite o telefone:");
        telefone = scan.nextLine();

        pessoa = new Pessoa(nome, cpf, email, telefone);

        return pessoa;
    }

    private static ContaBancaria cadastrarConta() {
        ContaBancaria conta;
        int numero, agencia;
        String senha, cpf, email;

        System.out.println("###Cadastro de Conta###");
        System.out.println("Digite o número:");
        numero = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite a agência:");
        agencia = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite a senha:");
        senha = scan.nextLine();
        System.out.println("Digite o cpf:");
        cpf = scan.nextLine();
        System.out.println("Digite o e-mail:");
        email = scan.nextLine();

        conta = new ContaBancaria(numero, agencia, 0.0, cpf, senha, email);

        return conta;

    }

    private static void depositar(ContaBancaria conta) {
        double valor;

        System.out.println("Depositar na conta");
        System.out.println("Digite o valor:");
        valor = scan.nextDouble();

        System.out.println(conta.depositar(valor));
    }

    private static void sacar(ContaBancaria conta) {
        double valor;

        System.out.println("Sacar da conta");
        System.out.println("Digite o valor:");
        valor = scan.nextDouble();

        System.out.println(conta.sacar(valor));
    }

    private static boolean adicionarPessoaVetor(Pessoa[] vetor, Pessoa nova) {

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == null) {
                vetor[i] = nova;
                return true;
            }
        }

        return false;

    }
    private static boolean adicionarContasVetor(ContaBancaria[] vetor, ContaBancaria nova) {

        for( int i=0; i<vetor.length; i++){
            if(vetor[i] == null){
                vetor[i] = nova;
                return true;
            }
        }

        return false;
    }

    private static void mostrarVetorPessoas(Pessoa[] pessoas) {
        System.out.println("###Pessoas Cadastradas###");
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                System.out.println("[" + i + "]->" + pessoas[i].toString());
            } else {
                System.out.println("[" + i + "]-> Livre");
            }
        }
    }

    private static void mostrarVetorContas (ContaBancaria[] contas){
        System.out.println("###Contas Cadastradas");
        for(int i=0; i<contas.length; i++){
            if(contas[i] != null){
                System.out.println("["+i+"] ->" +contas[i].toString());
            } else{
                System.out.println("["+i+"]-> Livre");
            }
        }
    }

    public static void main(String[] args) {

        scan = new Scanner(System.in);

        // declarar
        ContaBancaria conta = null;
        Pessoa pessoa = null;
        Pessoa[] pessoas = new Pessoa[10];
        ContaBancaria[] contas = new ContaBancaria[10];

        int opcao;

        do {
            System.out.println(menu());
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    pessoa = cadastrarPessoa();
                    boolean resultado = adicionarPessoaVetor(pessoas, pessoa);
                    if (resultado) {
                        System.out.println("Pessoa adicionada!!");
                    } else {
                        System.out.println("Erro! Sem espaço");
                    }
                    break;
                case 2:
                    mostrarVetorPessoas(pessoas);
                    break;
                case 3:
                    conta = cadastrarConta();
                    boolean resultadocontas = adicionarContasVetor(contas, conta);
                    if(resultadocontas){
                        System.out.println("Conta Cadastrada!!");
                    } else {
                        System.out.println("Erro! Sem espaço");
                    }
                    break;
                case 4:
                    System.out.println("Dados da conta");
                    System.out.println(conta.toString());
                    break;
                case 5:
                    depositar(conta);
                    break;
                case 6:
                    sacar(conta);
                    break;
            }

        } while (opcao != 0);

    }

}

// git config --local user.name "Hugo"
// git config --local user.email "haperlin@gmail.com"
