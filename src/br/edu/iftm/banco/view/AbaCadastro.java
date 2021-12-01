package br.edu.iftm.banco.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.iftm.banco.classes.Banco;
import br.edu.iftm.banco.classes.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AbaCadastro extends JPanel {

	JLabel labelNome;
	JTextField campoNome;
	JLabel labelSobrenome;
	JTextField campoSobrenome;
	JLabel labelCpf;
	JTextField campoCpf;
	JLabel labelDataNasc;
	JLabel labelDia;
	JTextField campoDia;
	JLabel labelMes;
	JTextField campoMes;
	JLabel labelAno;
	JTextField campoAno;
	JButton botaoCadastro;
	Banco banco;

	public AbaCadastro(Banco banco) {
		this.banco = banco;
		this.setLayout(null);

		labelNome = criaLabel("Nome:", 10, 11, 46, 14);
		campoNome = criaJTextField(104, 8, 128, 20);
		labelSobrenome = criaLabel("Sobrenome:", 10, 46, 84, 14);
		campoSobrenome = criaJTextField(104, 39, 128, 20);
		labelCpf = criaLabel("CPF:", 10, 83, 46, 14);
		campoCpf = criaJTextField(104, 70, 128, 20);
		labelDataNasc = criaLabel("Data de Nascimento", 10, 121, 128, 14);
		labelDia = criaLabel("Dia:", 10, 161, 46, 14);
		campoDia = criaJTextField(104, 155, 86, 20);
		labelMes = criaLabel("Mes:", 10, 199, 46, 14);
		campoMes = criaJTextField(104, 196, 86, 20);
		labelAno = criaLabel("Ano: ", 10, 238, 46, 14);
		campoAno = criaJTextField(104, 235, 86, 20);

		botaoCadastro = new JButton("Cadastrar");
		botaoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoCadastro();
			}
		});
		botaoCadastro.setBounds(101, 288, 131, 23);
		this.add(botaoCadastro);
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

	public void botaoCadastro() {
		String nome = campoNome.getText();
		String sobreNome = campoSobrenome.getText();
		String cpf = campoCpf.getText();
		int dia = Integer.parseInt(campoDia.getText());
		int mes = Integer.parseInt(campoMes.getText());
		int ano = Integer.parseInt(campoAno.getText());
		Cliente cl = new Cliente(nome, sobreNome, cpf, dia, mes, ano);
		banco.abrirConta(cl);
		JOptionPane.showMessageDialog(null, "cadastro realizado com sucesso!", "Mensagem",
				JOptionPane.INFORMATION_MESSAGE);
		campoNome.setText("");
		campoSobrenome.setText("");
		campoCpf.setText("");
		campoDia.setText("");
		campoMes.setText("");
		campoAno.setText("");
	}

}
