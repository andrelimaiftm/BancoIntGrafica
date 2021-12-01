package br.edu.iftm.banco.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.iftm.banco.classes.Banco;
import br.edu.iftm.banco.classes.Conta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AbaDeposito extends JPanel {

    JLabel numeroDepositoLabel;
    JTextField CampoNumeroDeposito;
    JLabel valorDepositoLabel;
    JTextField campoValorDeposito;
    JButton botaoDepositar;
    Banco banco;

    public AbaDeposito(Banco banco) {
        this.banco = banco;
        this.setLayout(null);

        numeroDepositoLabel = criaLabel("Numero:", 10, 11, 66, 14);
        CampoNumeroDeposito = criaJTextField(79, 8, 86, 20);
        valorDepositoLabel = criaLabel("Valor:", 10, 60, 66, 14);
        campoValorDeposito = criaJTextField(79, 57, 86, 20);

        botaoDepositar = new JButton("Depositar");
        botaoDepositar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botaoDepositar();
            }
        });
        botaoDepositar.setBounds(79, 120, 89, 23);
        this.add(botaoDepositar);

    }

    public JLabel criaLabel(String nomeCampo, int x, int y, int largura, int altura) {
        JLabel label = new JLabel(nomeCampo);
        label.setBounds(x, y, largura, altura);
        this.add(label);
        return label;
    }

    public JTextField criaJTextField(int x, int y, int largura, int altura) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, largura, altura);
        this.add(textField);
        textField.setColumns(10);
        return textField;
    }

    public void botaoDepositar() {
        int numero = Integer.parseInt(CampoNumeroDeposito.getText());
        double valorDeposito = Double.parseDouble(campoValorDeposito.getText());
        Conta c = banco.buscarConta(numero);
        if (c != null) {
            if (banco.operacaoDeposito(c, valorDeposito)) {
                JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso!", "Mensagem",
                        JOptionPane.INFORMATION_MESSAGE);
                CampoNumeroDeposito.setText("");
                campoValorDeposito.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Conta invalida!", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }
}
