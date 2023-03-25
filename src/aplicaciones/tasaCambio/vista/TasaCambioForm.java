package aplicaciones.tasaCambio.vista;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import aplicaciones.tasaCambio.vista.form.ConversionTC;
import global_helpers.vista.Tabla;
import global_helpers.vista.ZFrame;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

@SuppressWarnings("serial")
public class TasaCambioForm extends ZFrame{

	private JPanel contentPane;
	
	private JPanel formPanel;
	
	private ConversionTC conversionTC;
	
	private JScrollPane JScrollPrincipal;
	private JScrollPane JScrollTabla;
	
	private Tabla tabla;
	
	public TasaCambioForm() {
		super("Tasa de cambio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initComponents();
	}
	
	public ConversionTC getConversionTC() {
		return this.conversionTC;
	}
	
	public Tabla getTabla() {
		return this.tabla;
	}
	
	private void initComponents(){

		addResponsive();
		
		contentPane = new JPanel();
		setMinimumSize(new Dimension(600, 400));
		//localizamos la ventana en el centro
		setLocationRelativeTo(null);
		
		getEncabezado().setImageTitulo("/aplicaciones/tasaCambio/imagenes/tasa_cambio.png");
				
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		JScrollPrincipal=new JScrollPane();
		JScrollPrincipal.setHorizontalScrollBar(null);
		JScrollPrincipal.setOpaque(false);
		JScrollPrincipal.getViewport().setOpaque(false);
		contentPane.add(JScrollPrincipal);
		
		JScrollPrincipal.setViewportView(getContentPanel());
		
		getCentralPanel().setLayout(new BorderLayout());
		
		formPanel=new JPanel();
		formPanel.setLayout(null);
		formPanel.setOpaque(false);
		formPanel.setPreferredSize(new Dimension(400,250));
		getCentralPanel().add(formPanel, BorderLayout.CENTER);
		
		JScrollTabla=new JScrollPane();
		JScrollTabla.setBorder(new EmptyBorder(20, 30, 30, 30));
		JScrollTabla.setPreferredSize(new Dimension(550,350));
		JScrollTabla.setOpaque(false);
		
		conversionTC=new ConversionTC();
		formPanel.add(conversionTC,BorderLayout.CENTER);
		
		tabla = new Tabla();
		
		JScrollTabla.setViewportView(tabla);
		
	}
	
	private void addResponsive() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int h=0;
				int w=0;
				if(getSize().width<1000) {
					h=0;
					w=(contentPane.getWidth()-conversionTC.getWidth()-25)/2;
					getCentralPanel().add(JScrollTabla,BorderLayout.SOUTH);
				}else if(getSize().width>=1000) {
					h=(contentPane.getHeight()-getFooter().getHeight()-getEncabezado().getHeight()-conversionTC.getHeight())/2;
					w=(contentPane.getWidth()-600-conversionTC.getWidth())/2;
					getCentralPanel().add(JScrollTabla,BorderLayout.EAST);
				}
				conversionTC.setBounds(w,h,560,250);
			}
		});		
	}

}