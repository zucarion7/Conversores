package global_helpers.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import global_helpers.control.ColorChanger;

@SuppressWarnings("serial")
public class ZFrame extends JFrame{

	private JPanel contentPane;
	private JPanel centralPanel;
	
	private Encabezado encabezado;
	private Footer footer;
	
	private ColorChanger colorChanger;
	
	public ZFrame(String titulo) {
		setTitle(titulo);
		initComponents();
	}
	
	public JPanel getContentPanel() {
		return this.contentPane;
	}
	
	public JPanel getCentralPanel() {
		return this.centralPanel;
	}
	
	public Encabezado getEncabezado() {
		return this.encabezado;
	}
	
	public Footer getFooter() {
		return this.footer;
	}

	private void initComponents() {
		
		colorChanger=new ColorChanger(this,false);
		
		contentPane=new JPanel();
//		setMinimumSize(new Dimension(600, 400));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setLayout(new BorderLayout());
		
		//damos un icono a nuestra ventana
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/icon.png")).getImage());
		
		centralPanel=new JPanel();
		centralPanel.setOpaque(false);
		centralPanel.setBorder(BorderFactory.createLineBorder(Color.red));
		contentPane.add(centralPanel,BorderLayout.CENTER);
		
		encabezado=new Encabezado();
		contentPane.add(encabezado,BorderLayout.NORTH);
		
		footer=new Footer();
		contentPane.add(footer,BorderLayout.SOUTH);
		
		addEventCambioColor();
	}

	public void setColorBackground(Color color) {
		contentPane.setBackground(color);
	}
	
	private void addEventCambioColor() {
		encabezado.getBtnPaletaColor().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				colorChanger.setVisible(true);
			}
		});
	}
	
}
