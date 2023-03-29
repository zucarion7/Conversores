package aplicaciones.tasaCambio.helpers.ventena;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import aplicaciones.tasaCambio.vista.TasaCambioForm;
import conversoresApp.conversoresVista.ConversoresForm;

public class TCControlVentana {

	private TasaCambioForm ventana;
	private ConversoresForm ventanaPrincipal;
	
	public TCControlVentana(TasaCambioForm ventana,ConversoresForm vPrincipal) {
		this.ventana=ventana;
		this.ventanaPrincipal=vPrincipal;
	}
	
	public void iniciar() {
		addCloseVentanaEvent();
		ventana.setVisible(true);
	}
	
	private void addCloseVentanaEvent() {
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ventanaPrincipal.setVisible(true);
			}
		});
	}
}
