import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela_Botao extends JFrame {
        private JTextField tf1;
	private JButton bt1,bt2,bt3,bt4,bt5;
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
                                        Janela_Morador m = new Janela_Morador();
                                        boolean teste = m.getinserido();
                                        if(teste)
                                        {JOptionPane.showMessageDialog(null,"Morador Inserido \n");              
					}
                                        else
                                        {JOptionPane.showMessageDialog(null,"Erro nao foi possivel inserir \n");
                                        }
                                }});
		bt2 = new JButton("Procurar Morador");
		add(bt2);
		bt2.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					layout.setAlignment(FlowLayout.CENTER);
					layout.layoutContainer(container);
					}});
		bt3 = new JButton("Atualizar Dados");
		add(bt3);
		bt3.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					layout.setAlignment(FlowLayout.CENTER);
					layout.layoutContainer(container);
					}});
                bt4 = new JButton("Deletar Morador");
		add(bt4);
		bt4.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					layout.setAlignment(FlowLayout.CENTER);
					layout.layoutContainer(container);
					}});
                bt5 = new JButton("Escrever Relatorio");
		add(bt5);
		bt5.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					layout.setAlignment(FlowLayout.CENTER);
					layout.layoutContainer(container);
					}});
	
		}
        static public void main(String[] args) {
        	Janela_Botao janela = new Janela_Botao();
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(250,350);
		janela.setVisible(true);
  }
}

