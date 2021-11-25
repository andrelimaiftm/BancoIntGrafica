package br.edu.iftm.banco.classes;

public class Conta {

    private static int totalDeContas;
    
    private int numero;
    private double saldo;
    private double limite;
    private Cliente cliente;

    public Conta(){ 
        Conta.totalDeContas = Conta.totalDeContas+1;
    }

    public Conta(Cliente cliente){
        this();
        this.cliente = cliente;
    }   

    public Conta(int numero, Cliente cliente){        
        this(cliente);
        this.numero = numero;        
    }    

    public boolean sacar(double valorSaque){        
        if(verificaSaldo(valorSaque)){            
            this.saldo -= valorSaque;            
            return true;
        }else{            
            return false;
        }
    }

    public boolean depositar(double valorDeposito){
        if(valorDeposito > 0){            
            this.saldo += valorDeposito;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valorTransferencia){
        if(verificaSaldo(valorTransferencia)){
            this.saldo -= valorTransferencia;
            destino.depositar(valorTransferencia);           
            return true;
        }        
        return false;
    }

    private boolean verificaSaldo(double valor){
        double saldoTotal = this.saldo + this.limite;
        if(saldoTotal >= valor){            
            return true;
        }
        imprimirMensagem("Saldo Insuficiente!!!");
        return false;
    }

    private void imprimirMensagem(String msg){
        System.out.println(msg);
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    /**
     * @return double return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    /*public void setSaldo(double saldo) {
        this.saldo = saldo;
    }*/

    /**
     * @return double return the limite
     */
    public double getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(double limite) {
        this.limite = limite;
    }    

    /**
     * @return Cliente return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getTotalDeContas(){
        return Conta.totalDeContas;
    }

}