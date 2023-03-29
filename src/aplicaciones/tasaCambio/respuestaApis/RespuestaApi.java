package aplicaciones.tasaCambio.respuestaApis;

import javax.swing.JOptionPane;

import aplicaciones.tasaCambio.helpers.API;
import aplicaciones.tasaCambio.helpers.TCDatos;
import global_helpers.control.JOptionPanePersonalizador;

public class RespuestaApi {

	private TCDatos controlDatos=new TCDatos();
	private API api_codigoMonedas;
	private API api_nombreMonedas;
	private JOptionPanePersonalizador JOPanePers=new JOptionPanePersonalizador();
	
	public RespuestaApi() {
		consumirApis();
	}
	
	private void consumirApis() {
		this.api_codigoMonedas=new API("https://api.exchangerate-api.com/v4/latest/COP");
		JOPanePers.Personalizar();
		JOptionPane.showMessageDialog(null, "Esperar unos segundos respuesta de la API");
		this.api_codigoMonedas.consumoApi();
		if(this.api_codigoMonedas.getValidacion()) {
			api_nombreMonedas=new API("https://openexchangerates.org/api/currencies.json");
			api_nombreMonedas.consumoApi();
			if(this.api_nombreMonedas.getValidacion()) {
				controlDatos.setAPICodigos(api_codigoMonedas);
				controlDatos.setAPINombres(api_nombreMonedas);
				controlDatos.iniciar();
			}
		}
	}

	public TCDatos getControlDatos() {
		return this.controlDatos;
	}
	
	public boolean validacionApis() {
		return !api_codigoMonedas.getValidacion() || !api_nombreMonedas.getValidacion()? false:true;
	}
}
