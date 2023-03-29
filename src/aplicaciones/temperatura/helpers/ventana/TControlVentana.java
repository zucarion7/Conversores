package aplicaciones.temperatura.helpers.ventana;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import aplicaciones.temperatura.vista.TemperaturaForm;
import conversoresApp.conversoresVista.ConversoresForm;

public class TControlVentana {

	private TemperaturaForm ventana;
	private ConversoresForm ventanaPrincipal;
	
	public TControlVentana(TemperaturaForm owner,ConversoresForm vPrincipal) {
		this.ventana=owner;
		this.ventanaPrincipal=vPrincipal;
	}
	
	public void iniciar() {
		addCloseVentanaEvent();
		ventana.setVisible(true);
	}
	
	public ConversoresForm getVP() {
		return this.ventanaPrincipal;
	}
	
	//agregamos todos los eventos
	private void addCloseVentanaEvent() {
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ventanaPrincipal.setVisible(true);
			}
		});
	}
}
