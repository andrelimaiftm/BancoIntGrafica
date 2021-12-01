package br.edu.iftm.banco.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.iftm.banco.classes.Banco;
import br.edu.iftm.banco.classes.Conta;

public class AbaSaque extends JPanel {

    JLabel labelNumero;
    JTextField campoNumero;
    JLabel labelValor;
    JTextField campoValorSaque;
    Banco banco;    

    public AbaSaque(Banco banco) {
        this.banco = banco;        
        this.setLayout(null);        
        labelNumero = criaLabel("Numero:", 10, 11, 65, 14);
        campoNumero = criaJTextField(83, 8, 86, 20);       
        labelValor = criaLabel("Valor:", 10, 52, 46, 14);
        campoValorSaque = criaJTextField(83, 49, 86, 20);       

        JButton botaoSaque = new JButton("Saque");
        botaoSaque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botaoSaque();
            }
        });
        botaoSaque.setBounds(45, 99, 89, 23);
        this.add(botaoSaque);
    }

    public JLabel criaLabel(String nomeCampo, int x, int y, int largura, int altura){
        JLabel label = new JLabel(nomeCampo);
        label.setBounds(x, y, largura, altura);
        this.add(label);
        return label;
    }

    public JTextField criaJTextField( int x, int y, int largura, int altura){
        JTextField textField = new JTextField();
        textField.setBounds(x, y, largura, altura);
        this.add(textField);
        textField.setColumns(10);
        return textField;
    }

    public void botaoSaque(){
        int numero = Integer.parseInt(campoNumero.getText());
                float valorSaque = Float.parseFloat(campoValorSaque.getText());
                Conta c = banco.buscarConta(numero);
                if (c != null) {
                    if (banco.operacaoSaque(c, valorSaque)) {
                        JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                        campoNumero.setText("");
                        campoValorSaque.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Conta invalida!", "Mensagem", JOptionPane.ERROR_MESSAGE);
                }
    }

}
