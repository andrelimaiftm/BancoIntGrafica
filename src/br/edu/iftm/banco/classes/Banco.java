package br.edu.iftm.banco.classes;

public class Banco {

    private int indice;

    private String nome;
    private Conta[] vetorContas;

    public Banco() {
        vetorContas = new Conta[10];
    }

    public Banco(String nome, int numeroDeContas) {
        this.nome = nome;
        vetorContas = new Conta[numeroDeContas];
    }

    public void abrirConta(Cliente cl) {
        Conta c = new Conta(cl);
        c.setNumero(c.getTotalDeContas());
        this.vetorContas[indice] = c;
        indice++;
    }

    public Conta buscarConta(int numero) {
        if (vetorContas[0] != null) {
            for (Conta conta : vetorContas) {
                if (conta != null && conta.getNumero() == numero) {
                    return conta;
                }
            }
        }
        return null;
    }

    public boolean operacaoSaque(Conta conta, double valor) {
        return conta.sacar(valor);
    }

    public boolean operacaoDeposito(Conta conta, double valor) {
        return conta.depositar(valor);
    }

    public boolean operacaoTransferir(Conta conta, Conta destino, double valor) {
        return conta.transferir(destino, valor);
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
