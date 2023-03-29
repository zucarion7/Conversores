package conversoresApp.helpers.ventana.helpers;

import aplicaciones.sistemasNumericos.SistemasNumericosApp;
import aplicaciones.tasaCambio.TasaCambioApp;
import aplicaciones.tasaCambio.respuestaApis.RespuestaApi;
import aplicaciones.temperatura.TemperaturaApp;
import conversoresApp.helpers.ventana.CControlVentana;

public class CControlSeleccion {
	
	private CControlVentana controlVentana;
	
	public void setControlVentana(CControlVentana cv) {
		this.controlVentana=cv;
	}
	
	public void seleccionar(String seleccion) {
		switch(seleccion) {
			case "Tasa de cambio de divisas":
				iniciarTasaCambioApp();
			break;
			case "Conversor de temperatura":
				iniciarTemperaturaApp();
			break;
			case "Conversor de sistemas numéricos":
				iniciarSistemNumerApp();
			break;			
		}
	}

	private void iniciarTasaCambioApp() {
		RespuestaApi apiRespuesta=new RespuestaApi();
		if(apiRespuesta.validacionApis()) {
			TasaCambioApp app=new TasaCambioApp();
			controlVentana.invisible();
			app.setPadre(controlVentana.getVentana());
			app.setControlDatos(apiRespuesta.getControlDatos());
			app.iniciar();
		}
	}
	
	private void iniciarTemperaturaApp() {
		TemperaturaApp app=new TemperaturaApp();
		controlVentana.invisible();
		app.setPadre(controlVentana.getVentana());
		app.iniciar();
	}
	
	private void iniciarSistemNumerApp() {
		SistemasNumericosApp app=new SistemasNumericosApp();
		controlVentana.invisible();
		app.setPadre(controlVentana.getVentana());
		app.iniciar();
	}
}
