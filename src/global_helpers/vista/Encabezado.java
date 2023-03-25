package global_helpers.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import global_helpers.control.ImageSet;

@SuppressWarnings("serial")
public class Encabezado extends JPanel {
	
	private JPanel tituloPanel;
	
	private JPanel botonPanel;
	
	private JLabel lblTitulo;
	private JButton btnPaletaColor;
	
	private ImageSet imageSet;
	
	public Encabezado() {
		initComponent();
	}
	
	public JButton getBtnPaletaColor() {
		return this.btnPaletaColor;
	}
	
	private void initComponent() {
		
		imageSet=new ImageSet();
		
		setLayout(new BorderLayout());
		setOpaque(false);
		setBorder(BorderFactory.createLineBorder(Color.blue));
		
		tituloPanel = new JPanel();
		tituloPanel.setLayout(null);
		tituloPanel.setOpaque(false);
		tituloPanel.setPreferredSize(new Dimension(470,100));
		add(tituloPanel,BorderLayout.CENTER);
		
		lblTitulo = new JLabel();
		lblTitulo.setBounds(65, 5, 350, 100);
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		tituloPanel.add(lblTitulo);
		
		botonPanel=new JPanel();
		botonPanel.setLayout(null);
		botonPanel.setOpaque(false);
		botonPanel.setPreferredSize(new Dimension(30,30));
		add(botonPanel,BorderLayout.EAST);
		
//		lblPaletaColor=new JLabel();
//		lblPaletaColor.setIcon(imageSet.getIcon("/imagenes/paletaColores.png",25,25));
//		lblPaletaColor.setVerticalAlignment(SwingConstants.TOP);
//		add(lblPaletaColor,BorderLayout.EAST);
		
		btnPaletaColor=new JButton();
		btnPaletaColor.setSize(30, 30);
		btnPaletaColor.setFocusPainted(false);
		btnPaletaColor.setContentAreaFilled(false);
		btnPaletaColor.setOpaque(false);
		btnPaletaColor.setIcon(imageSet.getIcon("/imagenes/paletaColores.png",25,25));
		btnPaletaColor.setVerticalAlignment(SwingConstants.TOP);
		botonPanel.add(btnPaletaColor);
	}
	
	public void setImageTitulo(String dirImageTitulo) {
		lblTitulo.setIcon(imageSet.getIcon(dirImageTitulo,350,100));
	}

}
