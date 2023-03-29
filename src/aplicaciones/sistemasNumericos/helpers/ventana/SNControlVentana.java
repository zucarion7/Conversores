package aplicaciones.sistemasNumericos.helpers.ventana;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import aplicaciones.sistemasNumericos.vista.SistemaNumericoForm;
import conversoresApp.conversoresVista.ConversoresForm;

public class SNControlVentana {
	
	private SistemaNumericoForm ventana;
	private ConversoresForm ventanaPrincipal;
	
	public SNControlVentana(SistemaNumericoForm owner,ConversoresForm vPrincipal) {
		this.ventana=owner;
		this.ventanaPrincipal=vPrincipal;
	}
	
	public void iniciar() {
		addCloseVentanaEvent();
		ventana.setVisible(true);
	}
	
	private void addCloseVentanaEvent() {
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				ventanaPrincipal.setVisible(true);
			}
		});		
	}

}