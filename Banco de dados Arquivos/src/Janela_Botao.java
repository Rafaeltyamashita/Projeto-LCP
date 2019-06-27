import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela_Botao extends JFrame {
        private JTextField tf1;
	private JButton bt1,bt2,bt3,bt4,bt5,bt6,bt7;
	private FlowLayout layout;
	private Container container;
	public Janela_Botao() {
    		super("Condominio"); 
		layout = new FlowLayout();
                tf1 = new JTextField("Administração Condominio",16);
		tf1.setEditable(false);
		container = getContentPane();
		setLayout(layout);
                add(tf1);
		bt1 = new JButton("Inserir Morador");
		add(bt1);
		bt1.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					layout.setAlignment(FlowLayout.CENTER);
					layout.layoutContainer(container);
                                        Janela_Insere m = new Janela_Insere();
                                }});
		bt2 = new JButton("Procurar um Morador");
		add(bt2);
		bt2.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					layout.setAlignment(FlowLayout.CENTER);
					layout.layoutContainer(container);
                                        Janela_Procura_Morador j = new Janela_Procura_Morador();
					}});
		bt3 = new JButton("Procurar informações em comum");
		add(bt3);
		bt3.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					layout.setAlignment(FlowLayout.CENTER);
					layout.layoutContainer(container);
                                        Janela_Procura m = new Janela_Procura();
					}});
                bt4 = new JButton("Atualizar Dados");
		add(bt4);
		bt4.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					layout.setAlignment(FlowLayout.CENTER);
					layout.layoutContainer(container);
                                        Janela_Update j = new Janela_Update();
					}});
                bt5 = new JButton("Deletar Morador");
		add(bt5);
		bt5.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					layout.setAlignment(FlowLayout.CENTER);
					layout.layoutContainer(container);
                                        Janela_Exclui j = new Janela_Exclui();
					}});
                bt6 = new JButton("Mudança de Morador");
		add(bt6);
		bt6.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					layout.setAlignment(FlowLayout.CENTER);
					layout.layoutContainer(container);
                                        Janela_Mudança d = new Janela_Mudança();
					}});
                bt7 = new JButton("Escrever Relatorio");
		add(bt7);
		bt6.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					layout.setAlignment(FlowLayout.CENTER);
					layout.layoutContainer(container);
					}});
	
		}
}

