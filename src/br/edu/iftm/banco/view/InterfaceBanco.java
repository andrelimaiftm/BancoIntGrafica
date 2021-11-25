package br.edu.iftm.banco.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import br.edu.iftm.banco.classes.*;

public class InterfaceBanco {

	private JFrame janela;
	private JTextField campoNome;
	private JTextField campoSobrenome;
	private JTextField campoCpf;
	private JTextField campoDia;
	private JTextField campoMes;
	private JTextField campoAno;

	private Banco banco;
	private JTextField campoNumero;
	private JTextField campoValorSaque;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		InterfaceBanco window = new InterfaceBanco();
		window.janela.setVisible(true);

	}

	/**
	 * Create the application.
	 */
	public InterfaceBanco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		banco = new Banco("Caixa", 20);
		janela = new JFrame();
		janela.setBounds(100, 100, 388, 472);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(null);
		
		JPanel abaCadastro = new JPanel();
		JPanel abaSaque = new JPanel();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 377, 421);
		janela.getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("Cadastrar", abaCadastro);
		abaCadastro.setLayout(null);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 11, 46, 14);
		abaCadastro.add(labelNome);
		
		campoNome = new JTextField();
		campoNome.setBounds(104, 8, 128, 20);
		abaCadastro.add(campoNome);
		campoNome.setColumns(10);
		
		JLabel labelSobrenome = new JLabel("Sobrenome:");
		labelSobrenome.setBounds(10, 46, 84, 14);
		abaCadastro.add(labelSobrenome);
		
		campoSobrenome = new JTextField();
		campoSobrenome.setBounds(104, 39, 128, 20);
		abaCadastro.add(campoSobrenome);
		campoSobrenome.setColumns(10);
		
		JLabel labelCpf = new JLabel("CPF:");
		labelCpf.setBounds(10, 83, 46, 14);
		abaCadastro.add(labelCpf);
		
		campoCpf = new JTextField();
		campoCpf.setBounds(104, 70, 128, 20);
		abaCadastro.add(campoCpf);
		campoCpf.setColumns(10);
		
		JLabel labelDataNasc = new JLabel("Data de Nascimento");
		labelDataNasc.setBounds(10, 121, 128, 14);
		abaCadastro.add(labelDataNasc);
		
		JLabel labelDia = new JLabel("Dia:");
		labelDia.setBounds(10, 161, 46, 14);
		abaCadastro.add(labelDia);
		
		campoDia = new JTextField();
		campoDia.setBounds(104, 155, 86, 20);
		abaCadastro.add(campoDia);
		campoDia.setColumns(10);
		
		JLabel labelMes = new JLabel("Mes:");
		labelMes.setBounds(10, 199, 46, 14);
		abaCadastro.add(labelMes);
		
		campoMes = new JTextField();
		campoMes.setBounds(104, 196, 86, 20);
		abaCadastro.add(campoMes);
		campoMes.setColumns(10);
		
		JLabel lbelAno = new JLabel("Ano: ");
		lbelAno.setBounds(10, 238, 46, 14);
		abaCadastro.add(lbelAno);
		
		campoAno = new JTextField();
		campoAno.setBounds(104, 235, 86, 20);
		abaCadastro.add(campoAno);
		campoAno.setColumns(10);
		
		JButton botaoCadastro = new JButton("Cadastrar");
		botaoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = campoNome.getText();
				String sobreNome = campoSobrenome.getText();
				String cpf = campoCpf.getText();
				int dia = Integer.parseInt(campoDia.getText());
				int mes = Integer.parseInt(campoMes.getText());
				int ano = Integer.parseInt(campoAno.getText());
				Cliente cl = new Cliente(nome, sobreNome, cpf, dia, mes, ano);
				banco.abrirConta(cl);
			}
		});
		botaoCadastro.setBounds(101, 288, 131, 23);
		abaCadastro.add(botaoCadastro);
		
		tabbedPane.addTab("Saquer", abaSaque);
		abaSaque.setLayout(null);
		
		JLabel labelNumero = new JLabel("Numero:");
		labelNumero.setBounds(10, 11, 65, 14);
		abaSaque.add(labelNumero);
		
		campoNumero = new JTextField();
		campoNumero.setBounds(60, 8, 86, 20);
		abaSaque.add(campoNumero);
		campoNumero.setColumns(10);
		
		JLabel labelValor = new JLabel("Valor:");
		labelValor.setBounds(10, 52, 46, 14);
		abaSaque.add(labelValor);
		
		campoValorSaque = new JTextField();
		campoValorSaque.setBounds(60, 49, 86, 20);
		abaSaque.add(campoValorSaque);
		campoValorSaque.setColumns(10);
		
		JButton botaoSaque = new JButton("Saque");
		botaoSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		botaoSaque.setBounds(45, 99, 89, 23);
		abaSaque.add(botaoSaque);
		
		
	}
}
