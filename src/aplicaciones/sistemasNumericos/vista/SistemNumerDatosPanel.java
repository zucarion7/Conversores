package aplicaciones.sistemasNumericos.vista;

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
public class SistemNumerDatosPanel extends JPanel{
	private Tabla tabla;
	private JScrollPane JScrollTabla;
	private JTextField txtNumero;
	private JComboBox<String> cbxSNumericos;
	
	private JPanel contenedorCbxTxt;
	
	public SistemNumerDatosPanel() {
		initComponent();
	}

	public Tabla getTabla() {
		return this.tabla;
	}
	
	public JTextField getTxtNumero() {
		return this.txtNumero;
	}
	
	public JComboBox<String> getCBXSNumericos() {
		return this.cbxSNumericos;
	}
	
	private void initComponent() {
		setLayout(new BorderLayout());
		
		contenedorCbxTxt=new JPanel();
		contenedorCbxTxt.setLayout(new FlowLayout());
		contenedorCbxTxt.setOpaque(false);
		add(contenedorCbxTxt,BorderLayout.NORTH);
		
		cbxSNumericos=new JComboBox<>();
		cbxSNumericos.setBackground(new Color(0,0,0));
		cbxSNumericos.setForeground(new Color(250,250,250));
		cbxSNumericos.setPreferredSize(new Dimension(200, 30));
		cbxSNumericos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxSNumericos.setBorder(BorderFactory.createLineBorder(new Color(53,56,61)));
		contenedorCbxTxt.add(cbxSNumericos);
		
		txtNumero=new JTextField();
		txtNumero.setPreferredSize(new Dimension(200,30));
		txtNumero.setFont(new Font("",Font.PLAIN,15));
		txtNumero.setBackground(new Color(53,56,61));
		txtNumero.setForeground(new Color(250,250,250));
		contenedorCbxTxt.add(txtNumero);
		
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
