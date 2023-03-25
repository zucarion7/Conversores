package aplicaciones.tasaCambio.vista.form;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import global_helpers.control.ImageSet;
import java.awt.Font;

@SuppressWarnings("serial")
public class ConversionTC extends JPanel{
	
	private ImageSet imageSet;
	private JLabel lblBaseID;
	private JLabel lblDivisaID;
	
	private JTextField txtBase;
	private JTextField txtDivisa;
	private JButton btnChange;
	private JComboBox<String> cbxBase;
	private JComboBox<String> cbxDivisa;
	
	public ConversionTC() {
		initComponents();
	}
	
	public JTextField getTXTBase() {
		return this.txtBase;
	}
	
	public JTextField getTXTDivisa() {
		return this.txtDivisa;
	}

	public JComboBox<String> getCBXBase(){
		return this.cbxBase;
	}
	
	public JComboBox<String> getCBXDivisa(){
		return this.cbxDivisa;
	}
	
	public JButton getBtnChange(){
		return this.btnChange;
	}
	
	public JLabel getLblBaseID() {
		return this.lblBaseID;
	}

	public JLabel getLblDivisaID() {
		return this.lblDivisaID;
	}
	
	private void initComponents() {
		
		setLayout(null);
		setSize(560,250);
		
		imageSet=new ImageSet();
		
		lblBaseID=new JLabel();
		lblBaseID.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		lblBaseID.setForeground(new Color(255, 255, 255));
		lblBaseID.setBounds(64, 57, 110, 35);
		add(lblBaseID);
		
		lblDivisaID=new JLabel();
		lblDivisaID.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		lblDivisaID.setForeground(new Color(255, 255, 255));
		lblDivisaID.setBounds(351, 57, 110, 35);
		add(lblDivisaID);
		
		txtBase=new JTextField();
		txtBase.setBounds(40, 176, 200, 30);
		txtBase.setFont(new Font("",Font.PLAIN,15));
		txtBase.setBackground(new Color(53,56,61));
		txtBase.setForeground(new Color(250,250,250));
		add(txtBase);
		
		txtDivisa=new JTextField();
		txtDivisa.setBounds(315, 176, 200, 30);
		txtDivisa.setFont(new Font("",Font.PLAIN,15));
		txtDivisa.setBackground(new Color(53,56,61));
		txtDivisa.setForeground(new Color(250,250,250));
		txtDivisa.setEditable(false); 
		add(txtDivisa);
		
		
		btnChange = new JButton();
		btnChange.setBounds(262, 114, 30, 30);
		btnChange.setIcon(imageSet.getIcon("/aplicaciones/tasaCambio/imagenes/change.png",btnChange.getWidth()-5,btnChange.getHeight()-5));
		add(btnChange);
		
		cbxBase = new JComboBox<String>();
		cbxBase.setBounds(40, 114, 200, 30);
		cbxBase.setBackground(new Color(0,0,0));
		cbxBase.setForeground(new Color(250,250,250));
		cbxBase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxBase.setBorder(BorderFactory.createLineBorder(new Color(53,56,61)));
		add(cbxBase);
		
		cbxDivisa = new JComboBox<String>();
		cbxDivisa.setBounds(315, 114, 200, 30);
		cbxDivisa.setBackground(new Color(0,0,0));
		cbxDivisa.setForeground(new Color(250,250,250));
		cbxDivisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxDivisa.setBorder(BorderFactory.createLineBorder(new Color(53,56,61)));
		add(cbxDivisa);
		setOpaque(false);
		setBorder(BorderFactory.createLineBorder(Color.blue));
	}

}
