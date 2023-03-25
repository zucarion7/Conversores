package conversoresApp.conversoresVista;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import global_helpers.vista.ZFrame;

@SuppressWarnings("serial")
public class ConversoresForm extends ZFrame {

	private InteraccionPanel interaccionPanel;
	
	public ConversoresForm() {
		super("Conversores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initComponents();
	}
	
	public InteraccionPanel getInteraccionPanel() {
		return this.interaccionPanel;
	}
	
	private void initComponents(){
		
		addResponsive();
		
		setMinimumSize(new Dimension(500, 440));
		//localizamos la ventana en el centro
		setLocationRelativeTo(null);
		
		getEncabezado().setImageTitulo("/imagenes/conversores.png");
		setContentPane(getContentPanel());
		
		getCentralPanel().setLayout(null);
		
		interaccionPanel=new InteraccionPanel();
		getCentralPanel().add(interaccionPanel);
		
	}
	
	private void addResponsive() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int h=0;
				int w=0;
				if(interaccionPanel!=null) {
					if(getSize().height>=440) {
						h=(getCentralPanel().getHeight()-interaccionPanel.getHeight())/2;
					}
				
					if(getWidth()>=500) {
						w=(getContentPanel().getWidth()-interaccionPanel.getWidth())/2;
					}
					interaccionPanel.setBounds(w,h,500,150);
				}
			}
		});
	}

}
