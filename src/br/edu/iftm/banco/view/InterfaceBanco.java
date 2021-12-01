package br.edu.iftm.banco.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import br.edu.iftm.banco.classes.Banco;

public class InterfaceBanco {

	private JFrame janela;
	private Banco banco;
	private AbaCadastro abaCadastro;
	private AbaSaque abaSaque;
	private AbaDeposito abaDeposito;
	private AbaSaldo abaSaldo;
	private AbaTransferencia abaTransferencia;

	

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

		abaCadastro = new AbaCadastro(banco);
		abaSaque = new AbaSaque(banco);
		abaDeposito = new AbaDeposito(banco);
		abaSaldo = new AbaSaldo(banco);
		abaTransferencia = new AbaTransferencia(banco);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 388, 472);
		janela.getContentPane().add(tabbedPane);

		tabbedPane.addTab("Cadastrar", abaCadastro);

		tabbedPane.addTab("Saque", abaSaque);

		tabbedPane.addTab("Depositar", abaDeposito);

		tabbedPane.addTab("Saldo", abaSaldo);

		tabbedPane.addTab("Transferencia", abaTransferencia);

	}
}
