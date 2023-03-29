package conversoresApp.helpers.ventana;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import conversoresApp.conversoresVista.ConversoresForm;

public class CControlVentana {

	private ConversoresForm ventana;
	
	public CControlVentana(ConversoresForm ventana) {
		this.ventana=ventana;
	}
	
	public ConversoresForm getVentana() {
		return this.ventana;
	}
	
	public void iniciar(){
		addCloseVentanaEvent();
		this.ventana.setVisible(true);
	}
	
	public void invisible() {
		ventana.setVisible(false);
	}
	
	private void addCloseVentanaEvent() {
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				System.exit(0); 
			}
		});		
	}
}
