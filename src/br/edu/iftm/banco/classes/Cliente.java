package br.edu.iftm.banco.classes;

public class Cliente {
    private String nome;
    private String sobrenome;
    private String cpf;
    private int dia;
    private int mes;
    private int ano;

    public Cliente (String cpf){
        if(this.validaCPF(cpf)){
            this.cpf = cpf;
        }else{
            imprimirMensagem("CPF não é valido");
        }
        
    }

    public Cliente(String nome, String sobrenome, String cpf, int dia, int mes, int ano) {
       if(this.validaCPF(cpf)){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
       } else{
        imprimirMensagem("CPF não é valido");
       }
    }

    private boolean validaCPF(String cpf){
        if(cpf.length() == 11){
            if(cpf.equals("00000000000")){
                return false;
            }else if(cpf.equals("11111111111")){
                return false;
            }else if(cpf.equals("22222222222")){
                return false;
            }else if(cpf.equals("33333333333")){
                return false;
            }else if(cpf.equals("44444444444")){
                return false;
            }else if(cpf.equals("55555555555")){
                return false;
            }else if(cpf.equals("66666666666")){
                return false;
            }else if(cpf.equals("77777777777")){
                return false;
            }else if(cpf.equals("88888888888")){
                return false;
            }else if(cpf.equals("99999999999")){
                return false;
            }
            return true;
        }
        return false;
    }
    
    private void imprimirMensagem(String msg){
        System.out.println(msg);
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
     * @return String return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return String return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    /*public void setCpf(String cpf) {
        this.cpf = cpf;
    }*/

    /**
     * @return int return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return int return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return int return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

}
