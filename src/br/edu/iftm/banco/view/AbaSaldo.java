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

public class AbaSaldo extends JPanel {

    JLabel numeroSaldoLabel;
    JTextField campoNumeroSaldo;
    JLabel nomeClienteLabel;
    JLabel nomeSaldoLabel;
    JLabel valorSaldoLabel;
    JLabel valorSaldo;
    Banco banco;

    public AbaSaldo(Banco banco) {
        this.banco = banco;
        this.setLayout(null);

        numeroSaldoLabel = criaLabel("Numero:", 10, 11, 67, 14);
        campoNumeroSaldo = criaJTextField(87, 8, 86, 20);
        nomeClienteLabel = criaLabel("Nome:", 10, 125, 95, 14);
        nomeSaldoLabel = criaLabel("", 107, 125, 197, 14);
        valorSaldoLabel = criaLabel("Saldo: ", 10, 183, 67, 14);
        valorSaldo = criaLabel("", 107, 183, 197, 14);

        JButton botaoSaldo = new JButton("Saldo");
        botaoSaldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botaoSaldo();
            }
        });
        botaoSaldo.setBounds(84, 67, 89, 23);
        this.add(botaoSaldo);
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

    public void botaoSaldo() {
        int numero = Integer.parseInt(campoNumeroSaldo.getText());
        Conta c = banco.buscarConta(numero);
        if (c != null) {
            campoNumeroSaldo.setText("");
            nomeSaldoLabel.setText(c.getCliente().getNome() + " " + c.getCliente().getSobrenome());
            valorSaldo.setText("" + c.getSaldo());
        } else {
            JOptionPane.showMessageDialog(null, "Conta invalida!", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }
}
