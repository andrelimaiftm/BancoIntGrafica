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

public class AbaTransferencia extends JPanel{

    JLabel numeroTransfOrigenLabel;
    JTextField campoNumeroOrigem;
    JLabel numeroTransfDestinoLabel;
    JTextField campoNumeroDestino;
    JLabel valorTransfLabel;
    JTextField campoValorTransferencia;
    JButton botaoTransferir;
    Banco banco;
    
    public AbaTransferencia(Banco banco){
        this.banco = banco;
        this.setLayout(null);
		
        numeroTransfOrigenLabel = criaLabel("Conta Origem:", 10, 24, 110, 14);
		campoNumeroOrigem = criaJTextField(142, 21, 86, 20);		
        numeroTransfDestinoLabel = criaLabel("Conta Destino:", 10, 76, 110, 14);
		campoNumeroDestino = criaJTextField(142, 73, 86, 20);
		valorTransfLabel = criaLabel("Valor:",10, 121, 110, 14);
		campoValorTransferencia = criaJTextField(142, 118, 86, 20);		
		
		botaoTransferir = new JButton("Transferencia");
		botaoTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoTransferir();
			}
		});
		botaoTransferir.setBounds(92, 177, 136, 23);
		this.add(botaoTransferir);
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

    public void botaoTransferir(){
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
}
