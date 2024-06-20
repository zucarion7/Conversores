package aplicaciones.tasaCambio.respuestaApis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import aplicaciones.tasaCambio.helpers.API;
import aplicaciones.tasaCambio.helpers.TCDatos;
import global_helpers.control.JOptionPanePersonalizador;

public class RespuestaApi {

	private TCDatos controlDatos=new TCDatos();
	private API api_codigoMonedas;
	private API api_nombreMonedas;
	private JOptionPanePersonalizador JOPanePers=new JOptionPanePersonalizador();
	private String URLRates;
	private String URLDivisas;
	
	public RespuestaApi() {
		consumirApis();
	}
	
	private void consumirApis() {
		Properties p = new Properties();
		try {
			p.load(new FileReader("src/config.properties"));
			URLRates=p.getProperty("ratesAPI");
			
			URLDivisas=p.getProperty("divisasAPI");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		this.api_codigoMonedas=new API(URLRates);
		JOPanePers.Personalizar();
		JOptionPane.showMessageDialog(null, "Esperar unos segundos respuesta de la API");
		this.api_codigoMonedas.consumoApi();
		if(this.api_codigoMonedas.getValidacion()) {
			api_nombreMonedas=new API(URLDivisas);
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
