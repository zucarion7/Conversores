package conversoresApp.conversoresVista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class InteraccionPanel extends JPanel {
	
	private JLabel fondo;
	private JLabel lblSeleccione;
	private JComboBox<String> opcionesCBX;
	private JButton btnSelect;
	
	public InteraccionPanel() {
		initComponent();
	}
	
	public JComboBox<String> getOpcionesCBX() {
		return opcionesCBX;
	}
	
	public JButton getBtnSelect() {
		return this.btnSelect;
	}
	
	public JLabel getLblFondo() {
		return this.fondo;
	}

	private void initComponent() {
		
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.red));
		setBounds(0,0,500,150);
		setOpaque(false);
		
		opcionesCBX = new JComboBox<String>();
		opcionesCBX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		opcionesCBX.setBounds(130, 70, 30, 22);
		opcionesCBX.setSize(230, 30);
		opcionesCBX.setBackground(new Color(0,0,0));
		opcionesCBX.setForeground(new Color(250,250,250));
		opcionesCBX.setBorder(BorderFactory.createLineBorder(new Color(53,56,61)));
		add(opcionesCBX);
		
		btnSelect = new JButton("Seleccionar");
		btnSelect.setBounds(185, 105, 110, 27);
		btnSelect.setBackground(new Color(0,0,0));
		btnSelect.setForeground(new Color(250,250,250));
		add(btnSelect);
		
		lblSeleccione = new JLabel("Seleccione el tipo de conversor");
		lblSeleccione.setForeground(new Color(250, 250, 200));
		lblSeleccione.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lblSeleccione.setBounds(95, 27, 320, 30);
		add(lblSeleccione);
		
		fondo=new JLabel();
		fondo.setBounds(0,0,500,150);
		add(fondo);
	}
}
