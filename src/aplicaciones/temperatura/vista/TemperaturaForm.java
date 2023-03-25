package aplicaciones.temperatura.vista;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import global_helpers.vista.ZFrame;

@SuppressWarnings("serial")
public class TemperaturaForm extends ZFrame{

	private TemperaturaDatosPanel tdp;
	public TemperaturaForm() {
		super("Temperatura");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initComponents();
	}
	
	public TemperaturaDatosPanel getTDP() {
		return this.tdp;
	}
	
	private void initComponents() {
		addResponsive();
		setMinimumSize(new Dimension(600, 505));
		//localizamos la ventana en el centro
		setLocationRelativeTo(null);
		
		getEncabezado().setImageTitulo("/aplicaciones/temperatura/imagenes/temperatura.png");
				
		setContentPane(this.getContentPanel());
		
		getCentralPanel().setLayout(null);
		
		tdp=new TemperaturaDatosPanel();
		getCentralPanel().add(tdp);
	}
	
	private void addResponsive() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int h=0;
				int w=0;
				if(getSize().height>=500) {
					h=(getCentralPanel().getHeight()-tdp.getHeight())/2;
				}
				
				if(getWidth()>=600) {
					w=(getContentPanel().getWidth()-tdp.getWidth())/2;
				}
				tdp.setBounds(w,h,500,190);
			}
		});
	}

}
