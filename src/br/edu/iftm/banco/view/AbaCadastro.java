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

public class AbaCadastro extends JPanel{

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

    public AbaCadastro(Banco banco){       
        this.banco = banco;
        this.setLayout(null);
		
		labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 11, 46, 14);
		this.add(labelNome);
		
		campoNome = new JTextField();
		campoNome.setBounds(104, 8, 128, 20);
		this.add(campoNome);
		campoNome.setColumns(10);
		
		labelSobrenome = new JLabel("Sobrenome:");
		labelSobrenome.setBounds(10, 46, 84, 14);
		this.add(labelSobrenome);
		
		campoSobrenome = new JTextField();
		campoSobrenome.setBounds(104, 39, 128, 20);
		this.add(campoSobrenome);
		campoSobrenome.setColumns(10);
		
		labelCpf = new JLabel("CPF:");
		labelCpf.setBounds(10, 83, 46, 14);
		this.add(labelCpf);
		
		campoCpf = new JTextField();
		campoCpf.setBounds(104, 70, 128, 20);
		this.add(campoCpf);
		campoCpf.setColumns(10);
		
		labelDataNasc = new JLabel("Data de Nascimento");
		labelDataNasc.setBounds(10, 121, 128, 14);
		this.add(labelDataNasc);
		
		labelDia = new JLabel("Dia:");
		labelDia.setBounds(10, 161, 46, 14);
		this.add(labelDia);
		
		campoDia = new JTextField();
		campoDia.setBounds(104, 155, 86, 20);
		this.add(campoDia);
		campoDia.setColumns(10);
		
		labelMes = new JLabel("Mes:");
		labelMes.setBounds(10, 199, 46, 14);
		this.add(labelMes);
		
		campoMes = new JTextField();
		campoMes.setBounds(104, 196, 86, 20);
		this.add(campoMes);
		campoMes.setColumns(10);
		
		labelAno = new JLabel("Ano: ");
		labelAno.setBounds(10, 238, 46, 14);
		this.add(labelAno);
		
		campoAno = new JTextField();
		campoAno.setBounds(104, 235, 86, 20);
		this.add(campoAno);
		campoAno.setColumns(10);
		
		botaoCadastro = new JButton("Cadastrar");
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
				JOptionPane.showMessageDialog(null, "cadastro realizado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				campoNome.setText("");
				campoSobrenome.setText("");
				campoCpf.setText("");
				campoDia.setText("");
				campoMes.setText("");
				campoAno.setText("");
			}
		});
		botaoCadastro.setBounds(101, 288, 131, 23);
		this.add(botaoCadastro);
    }
    
    
}
