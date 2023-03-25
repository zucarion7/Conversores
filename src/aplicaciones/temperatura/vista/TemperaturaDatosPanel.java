package aplicaciones.temperatura.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import global_helpers.vista.Tabla;

@SuppressWarnings("serial")
public class TemperaturaDatosPanel extends JPanel{
	
	private Tabla tabla;
	private JScrollPane JScrollTabla;
	private JTextField txtTemperatura;
	private JComboBox<String> cbxEscalas;
	
	private JPanel contenedorCbxTxt;
	
	public TemperaturaDatosPanel() {
		initComponent();
	}

	public Tabla getTabla() {
		return this.tabla;
	}
	
	public JTextField getTxtTemperatura() {
		return this.txtTemperatura;
	}
	
	public JComboBox<String> getCBXEscalas() {
		return this.cbxEscalas;
	}
	
	private void initComponent() {
		setLayout(new BorderLayout());
		
		contenedorCbxTxt=new JPanel();
		contenedorCbxTxt.setLayout(new FlowLayout());
		contenedorCbxTxt.setOpaque(false);
		add(contenedorCbxTxt,BorderLayout.NORTH);
		
		cbxEscalas=new JComboBox<>();
		cbxEscalas.setBackground(new Color(0,0,0));
		cbxEscalas.setForeground(new Color(250,250,250));
		cbxEscalas.setPreferredSize(new Dimension(200, 30));
		cbxEscalas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxEscalas.setBorder(BorderFactory.createLineBorder(new Color(53,56,61)));
		contenedorCbxTxt.add(cbxEscalas);
		
		txtTemperatura=new JTextField();
		txtTemperatura.setPreferredSize(new Dimension(200,30));
		txtTemperatura.setFont(new Font("",Font.PLAIN,15));
		txtTemperatura.setBackground(new Color(53,56,61));
		txtTemperatura.setForeground(new Color(250,250,250));
		contenedorCbxTxt.add(txtTemperatura);
		
		JScrollTabla=new JScrollPane();
		JScrollTabla.setBorder(new EmptyBorder(20, 30, 30, 30));
		JScrollTabla.setPreferredSize(new Dimension(500,148));
		JScrollTabla.setOpaque(false);
		
		tabla = new Tabla();
		
		JScrollTabla.setViewportView(tabla);
		add(JScrollTabla,BorderLayout.CENTER);
		
		setBorder(BorderFactory.createLineBorder(Color.blue));
		setOpaque(false);
	}
}
