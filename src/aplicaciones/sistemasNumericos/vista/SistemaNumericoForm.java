package aplicaciones.sistemasNumericos.vista;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import global_helpers.vista.ZFrame;

@SuppressWarnings("serial")
public class SistemaNumericoForm extends ZFrame {

	private SistemNumerDatosPanel sndp;
	public SistemaNumericoForm() {
		super("Sistemas numéricos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initComponents();
	}
	
	public SistemNumerDatosPanel getSNDP() {
		return this.sndp;
	}
	
	private void initComponents() {
		addResponsive();
		setMinimumSize(new Dimension(600, 520));
		//localizamos la ventana en el centro
		setLocationRelativeTo(null);
		
		getEncabezado().setImageTitulo("/aplicaciones/sistemasNumericos/imagenes/sistemas_numericos.png");
				
		setContentPane(this.getContentPanel());
		
		getCentralPanel().setLayout(null);
		
		sndp=new SistemNumerDatosPanel();
		getCentralPanel().add(sndp);
	}

	private void addResponsive() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int h=0;
				int w=0;
				if(getSize().height>=500) {
					h=(getCentralPanel().getHeight()-sndp.getHeight())/2;
				}
				
				if(getWidth()>=600) {
					w=(getContentPanel().getWidth()-sndp.getWidth())/2;
				}
				sndp.setBounds(w,h,500,215);
			}
		});
	}

}
