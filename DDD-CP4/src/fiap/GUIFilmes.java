package fiap;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
@SuppressWarnings({ "serial", "unused" }) 
public class GUIFilmes extends JPanel{
	
	private JButton btSalvar, btCancelar;
	private JLabel lbCodigo, lbTitulo, lbProdutora, lbGenero,lbImagem;
	private ImageIcon imagem1;
	private JTextField tfCodigo, tfTitulo;
	private JList<String> liGenero;
	private JScrollPane spLista;
	private JRadioButton rbWarner,rbFox,rbDisney,rbUniversal;
	private ButtonGroup buttonGroup;
	
	public GUIFilmes() {
		inicializarComponentes();
		definirEventos();
	}
	private void inicializarComponentes() {
		setBounds(0, 0, 600, 400);
		setLayout(null);
		String[] liItemsGeneros = {"Fantasia","Infantil","Medieval","Nordico","Terror"};
		liGenero = new JList<String>(liItemsGeneros);
		spLista = new JScrollPane(liGenero);
		lbCodigo = new JLabel("Código:",JLabel.RIGHT);
		lbTitulo = new JLabel("Titulo:",JLabel.RIGHT);
		lbProdutora = new JLabel("Produtora:",JLabel.RIGHT);
		lbGenero = new JLabel("Genero:",JLabel.RIGHT);
		tfCodigo = new JTextField();
		tfTitulo = new JTextField();
		rbWarner = new JRadioButton("Warner");
		rbFox = new JRadioButton("Fox");
		rbDisney = new JRadioButton("Disney");
		rbUniversal = new JRadioButton("Universal");
		imagem1 = new ImageIcon();
		lbImagem = new JLabel(imagem1);
		btSalvar = new JButton("Salvar");
		btCancelar = new JButton("Cancelar");
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rbWarner);
		buttonGroup.add(rbFox);
		buttonGroup.add(rbDisney);
		buttonGroup.add(rbUniversal);
		
		lbCodigo.setBounds(10,30,60,25);
		tfCodigo.setBounds(80,30,50,25);
		lbTitulo.setBounds(5,70,60,25);
		tfTitulo.setBounds(80,70,170,25);
		lbProdutora.setBounds(10,145,60,25);
		rbWarner.setBounds(20,170,100,25);
		rbFox.setBounds(20,195,100,25);
		rbDisney.setBounds(20,220,100,25);
		rbUniversal.setBounds(20,245,100,25);
		lbGenero.setBounds(265,30,60,25);
		spLista.setBounds(280,60,100,100);
		lbImagem.setBounds(420,25,180,180);
		btSalvar.setBounds(150,340,100,25);
		btCancelar.setBounds(400,340,100,25);
		
		add(lbCodigo);
		add(tfCodigo);
		add(lbTitulo);
		add(tfTitulo);
		add(lbProdutora);
		add(rbWarner);
		add(rbFox);
		add(rbDisney);
		add(rbUniversal);
		add(lbGenero);
		add(spLista);
		add(lbImagem);
		add(btSalvar);
		add(btCancelar);
	}
	private void definirEventos() {
		liGenero.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				imagem1 = new ImageIcon(getClass().getResource("Genero/" + liGenero.getSelectedValue() + ".png"));
				lbImagem.setIcon(imagem1);
				
			}
		});
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String produtora="";
				if (rbWarner.isSelected()) {
					produtora = "Warner";
				} else if (rbFox.isSelected()){
					produtora = "Fox";
				} else if (rbDisney.isSelected()){
					produtora = "Disney";
				} else if (rbUniversal.isSelected()){
					produtora = "Universal";
				}
				JOptionPane.showMessageDialog(null,"Filme selecionado:\nCódigo:" + tfCodigo.getText() + "\nTitulo:" + tfTitulo.getText() + "\nProdutora:" + produtora, "Filme", JOptionPane.INFORMATION_MESSAGE,imagem1);
			}
		});
	}
	
}
