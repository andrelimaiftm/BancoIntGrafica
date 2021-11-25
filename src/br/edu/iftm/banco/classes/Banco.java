package br.edu.iftm.banco.classes;

import javax.swing.JOptionPane;

public class Banco {

    private int indice;

    private String nome;
    private Conta[] vetorContas;

    public Banco(){
        vetorContas = new Conta[10];
    }

    public Banco(String nome, int numeroDeContas){
        this.nome = nome;
        vetorContas = new Conta[numeroDeContas];
    }

    public void abrirConta(Cliente cl){        
        Conta c = new Conta(cl);
        c.setNumero(c.getTotalDeContas());
        this.vetorContas[indice] = c;
        indice++;        
    }

    private String inputDados(String msg){
        String temp = JOptionPane.showInputDialog(null,msg);
        return temp;
    }

    private Cliente cadastroCliente(){
        String nome = inputDados("Digite o nome do Cliente:");
        String sobrenome = inputDados("Digite o sobrenome do Cliente:");
        String cpf = inputDados("Digite o cpf do Cliente:");
        String temp = inputDados("Digite o dia de nascimento do Cliente:");
        int dia = Integer.parseInt(temp);
        temp = inputDados("Digite o mês de nascimento do Cliente:");
        int mes = Integer.parseInt(temp);
        temp = inputDados("Digite o ano de nascimento do Cliente:");
        int ano = Integer.parseInt(temp);
        Cliente c = new Cliente(nome, sobrenome, cpf, dia, mes, ano);
        return c;
    }
    
    public Conta buscarConta(int numero){
        for (Conta conta : vetorContas) {
            if(conta.getNumero() == numero){
                return conta;
            }
        }
        return null;
    }

    private boolean operacaoSaque(Conta conta, double valor){
        return conta.sacar(valor);
    }

    private boolean operacaoDeposito(Conta conta, double valor){
        return conta.depositar(valor);
    }

    private boolean operacaoTransferir(Conta conta, Conta destino, double valor){
        return conta.transferir(destino, valor);
    }

    public int realizaOperacao(){
        System.out.println("Menu");
        System.out.println("1 - Abrir conta");
        System.out.println("2 - Efetuar saque");
        System.out.println("3 - Efetuar deposito");
        System.out.println("4 - Efetuar transferencia");
        System.out.println("0 - Sair");
        String temp = inputDados("Qual opção deseja escolher");
        int opcao =  Integer.parseInt(temp);
        if(opcao == 1){
            //abrirConta();
        }else if (opcao == 2){
            temp = inputDados("Digite numero da conta");
            int numero = Integer.parseInt(temp);
            Conta c = buscarConta(numero);
            if(c != null){
                temp = inputDados("Digite o valor do saque");
                double valor = Integer.parseInt(temp);
                operacaoSaque(c, valor);
            }
        }else if(opcao == 3){
            temp = inputDados("Digite numero da conta");
            int numero = Integer.parseInt(temp);
            Conta c = buscarConta(numero);
            if(c != null){
                temp = inputDados("Digite o valor do deposito");
                double valor = Integer.parseInt(temp);
                operacaoDeposito(c, valor);
            }
        }else if(opcao == 4){
            temp = inputDados("Digite numero da conta");
            int numero = Integer.parseInt(temp);
            Conta c = buscarConta(numero);
            temp = inputDados("Digite numero da conta para transferencia");
            numero = Integer.parseInt(temp);
            Conta d = buscarConta(numero);
            if(c != null && d != null){
                temp = inputDados("Digite o valor da tranferencia");
                double valor = Integer.parseInt(temp);
                operacaoTransferir(c, d, valor);
            }
        }
        return opcao;
    } 
    
    public void iniciar(){
        int opcao = 0;
        do {
            opcao =  realizaOperacao();
        } while (opcao != 0);       
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return Conta[] return the vetorContas
     */
    public Conta[] getVetorContas() {
        return vetorContas;
    }

    /**
     * @param vetorContas the vetorContas to set
     */
    public void setVetorContas(Conta[] vetorContas) {
        this.vetorContas = vetorContas;
    }
}
