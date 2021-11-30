package br.edu.iftm.banco.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField CampoNumeroDeposito;
	private JTextField campoValorDeposito;
	private JTextField campoNumeroSaldo;
	private JTextField campoNumeroOrigem;
	private JTextField campoNumeroDestino;
	private JTextField campoValorTransferencia;

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
		
		AbaCadastro abaCadastro = new AbaCadastro(banco);		
		JPanel abaSaque = new JPanel();
		JPanel abaDeposito = new JPanel();
		JPanel abaSaldo = new JPanel();
		JPanel abaTransferencia = new JPanel();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 388, 472);
		janela.getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("Cadastrar", abaCadastro);
		
		
		tabbedPane.addTab("Saquer", abaSaque);
		abaSaque.setLayout(null);
		
		JLabel labelNumero = new JLabel("Numero:");
		labelNumero.setBounds(10, 11, 65, 14);
		abaSaque.add(labelNumero);
		
		campoNumero = new JTextField();
		campoNumero.setBounds(83, 8, 86, 20);
		abaSaque.add(campoNumero);
		campoNumero.setColumns(10);
		
		JLabel labelValor = new JLabel("Valor:");
		labelValor.setBounds(10, 52, 46, 14);
		abaSaque.add(labelValor);
		
		campoValorSaque = new JTextField();
		campoValorSaque.setBounds(83, 49, 86, 20);
		abaSaque.add(campoValorSaque);
		campoValorSaque.setColumns(10);
		
		JButton botaoSaque = new JButton("Saque");
		botaoSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numero  = Integer.parseInt(campoNumero.getText());
				float valorSaque = Float.parseFloat(campoValorSaque.getText());
				Conta c = banco.buscarConta(numero);
				if(c != null){
					if(banco.operacaoSaque(c, valorSaque)){
						JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
						campoNumero.setText("");
						campoValorSaque.setText("");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Conta invalida!", "Mensagem", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botaoSaque.setBounds(45, 99, 89, 23);
		abaSaque.add(botaoSaque);
		
		tabbedPane.addTab("Depositar", abaDeposito);
		abaDeposito.setLayout(null);
		
		JLabel numeroDepositoLabel = new JLabel("Numero:");
		numeroDepositoLabel.setBounds(10, 11, 66, 14);
		abaDeposito.add(numeroDepositoLabel);
		
		CampoNumeroDeposito = new JTextField();
		CampoNumeroDeposito.setBounds(79, 8, 86, 20);
		abaDeposito.add(CampoNumeroDeposito);
		CampoNumeroDeposito.setColumns(10);
		
		JLabel valorDepositoLabel = new JLabel("Valor:");
		valorDepositoLabel.setBounds(10, 60, 66, 14);
		abaDeposito.add(valorDepositoLabel);
		
		campoValorDeposito = new JTextField();
		campoValorDeposito.setBounds(79, 57, 86, 20);
		abaDeposito.add(campoValorDeposito);
		campoValorDeposito.setColumns(10);
		
		JButton botaoDepositar = new JButton("Depositar");
		botaoDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numero  = Integer.parseInt(CampoNumeroDeposito.getText());
				double valorDeposito = Double.parseDouble(campoValorDeposito.getText());
				Conta c = banco.buscarConta(numero);
				if(c != null){
					if(banco.operacaoDeposito(c, valorDeposito)){
						JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
						CampoNumeroDeposito.setText("");
						campoValorDeposito.setText("");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Conta invalida!", "Mensagem", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botaoDepositar.setBounds(79, 120, 89, 23);
		abaDeposito.add(botaoDepositar);
		
		tabbedPane.addTab("Saldo", abaSaldo);
		abaSaldo.setLayout(null);
		
		JLabel numeroSaldoLabel = new JLabel("Numero:");
		numeroSaldoLabel.setBounds(10, 11, 67, 14);
		abaSaldo.add(numeroSaldoLabel);
		
		campoNumeroSaldo = new JTextField();
		campoNumeroSaldo.setBounds(87, 8, 86, 20);
		abaSaldo.add(campoNumeroSaldo);
		campoNumeroSaldo.setColumns(10);		
		
		JLabel nomeClienteLabel = new JLabel("Nome:");
		nomeClienteLabel.setBounds(10, 125, 95, 14);
		abaSaldo.add(nomeClienteLabel);
		
		JLabel nomeSaldoLabel = new JLabel("");
		nomeSaldoLabel.setBounds(107, 125, 197, 14);
		abaSaldo.add(nomeSaldoLabel);
		
		JLabel valorSaldoLabel = new JLabel("Saldo: ");
		valorSaldoLabel.setBounds(10, 183, 67, 14);
		abaSaldo.add(valorSaldoLabel);
		
		JLabel valorSaldo = new JLabel("");
		valorSaldo.setBounds(107, 183, 197, 14);
		abaSaldo.add(valorSaldo);
		
		JButton botaoSaldo = new JButton("Saldo");
		botaoSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numero  = Integer.parseInt(campoNumeroSaldo.getText());
				Conta c = banco.buscarConta(numero);
				if(c != null){
					campoNumeroSaldo.setText("");
					nomeSaldoLabel.setText(c.getCliente().getNome() + " " + c.getCliente().getSobrenome());
					valorSaldo.setText(""+c.getSaldo());					
				}else{
					JOptionPane.showMessageDialog(null, "Conta invalida!", "Mensagem", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botaoSaldo.setBounds(84, 67, 89, 23);
		abaSaldo.add(botaoSaldo);
		
		
		tabbedPane.addTab("Transferencia", abaTransferencia);
		abaTransferencia.setLayout(null);
		
		JLabel numeroTransfOrigenLabel = new JLabel("Conta Origem:");
		numeroTransfOrigenLabel.setBounds(10, 24, 110, 14);
		abaTransferencia.add(numeroTransfOrigenLabel);
		
		campoNumeroOrigem = new JTextField();
		campoNumeroOrigem.setBounds(142, 21, 86, 20);
		abaTransferencia.add(campoNumeroOrigem);
		campoNumeroOrigem.setColumns(10);
		
		JLabel numeroTransfDestinoLabel = new JLabel("Conta Destino:");
		numeroTransfDestinoLabel.setBounds(10, 76, 110, 14);
		abaTransferencia.add(numeroTransfDestinoLabel);
		
		campoNumeroDestino = new JTextField();
		campoNumeroDestino.setBounds(142, 73, 86, 20);
		abaTransferencia.add(campoNumeroDestino);
		campoNumeroDestino.setColumns(10);
		
		JLabel valorTransfLabel = new JLabel("Valor:");
		valorTransfLabel.setBounds(10, 121, 110, 14);
		abaTransferencia.add(valorTransfLabel);
		
		campoValorTransferencia = new JTextField();
		campoValorTransferencia.setBounds(142, 118, 86, 20);
		abaTransferencia.add(campoValorTransferencia);
		campoValorTransferencia.setColumns(10);
		
		JButton botaoTransferir = new JButton("Transferencia");
		botaoTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numeroOrigem =0;
				int numeroDestino = 0;
				double valorTransferencia = 0d;
				if(!campoNumeroOrigem.getText().isEmpty()){
					numeroOrigem = Integer.parseInt(campoNumeroOrigem.getText());
				}

				if(!campoNumeroDestino.getText().isEmpty()){
					numeroDestino = Integer.parseInt(campoNumeroDestino.getText());
				}
				
				if(!campoValorTransferencia.getText().isEmpty()){
					valorTransferencia = Double.parseDouble(campoValorTransferencia.getText());
				}
				
				Conta contaOrigem = banco.buscarConta(numeroOrigem);
				if(contaOrigem != null){
					Conta contaDestino = banco.buscarConta(numeroDestino);
					if(contaDestino != null){
						if(banco.operacaoTransferir(contaOrigem, contaDestino, valorTransferencia)){
							JOptionPane.showMessageDialog(null, "Transferencia realizada com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
							campoNumeroOrigem.setText("");
							campoNumeroDestino.setText("");
							campoValorTransferencia.setText("");
						}else{

						}
					}else{
					JOptionPane.showMessageDialog(null, "Conta de destino invalida!", "Mensagem", JOptionPane.ERROR_MESSAGE);
				}
				}else{
					JOptionPane.showMessageDialog(null, "Conta de origem invalida!", "Mensagem", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botaoTransferir.setBounds(92, 177, 136, 23);
		abaTransferencia.add(botaoTransferir);
		
		
	}
}
