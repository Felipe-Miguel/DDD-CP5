package fiap;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")

public class GUIPrincipall extends JFrame{
	private Container contentPane;
	private JMenuBar mnBarra;
	private JMenu mnArquivo, mnCadastros;
	private JMenuItem miSair,miFilme;
	
	public GUIPrincipall() {
		inicializarComponentes();
		definirEventos();
	}
	private void inicializarComponentes() {
		setTitle("Janela Principal");
		setBounds(0, 0, 800, 600);
		contentPane = getContentPane();
		mnBarra = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		mnCadastros = new JMenu("Cadastros");
		mnCadastros.setMnemonic('C');
		miSair = new JMenuItem("Sair", new ImageIcon(getClass().getResource("exit_icon.png")));
		miFilme = new JMenuItem("Filmes");
		
		
		//Adicionando componentes
		setJMenuBar(mnBarra);
		mnBarra.add(mnArquivo);
		mnBarra.add(mnCadastros);
		mnArquivo.add(miSair);
		mnCadastros.add(miFilme);
	}
	private void definirEventos() {
		miSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		
		miFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIFilmes filme = new GUIFilmes();
				contentPane.removeAll();
				contentPane.add(filme);
				contentPane.validate();
			}
		});
	}
	
	public void abrir() {
		GUIPrincipall frame = new GUIPrincipall();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2, 
				(tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}
	
}
