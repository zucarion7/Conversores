package aplicaciones.tasaCambio.respuestaApis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JOptionPane;

import aplicaciones.tasaCambio.helpers.API;
import aplicaciones.tasaCambio.helpers.TCDatos;
import global_helpers.control.JOptionPanePersonalizador;

public class RespuestaApi {

	private TCDatos controlDatos=new TCDatos();
	private API api_codigoMonedas;
	private API api_nombreMonedas;
	private Boolean exitoAPIS;
	private JOptionPanePersonalizador JOPanePers=new JOptionPanePersonalizador();
	private String URLRates;
	private String URLDivisas;
	
	public RespuestaApi() {
		consumirApis();
	}
	
	private void consumirApis() {
		Properties p = new Properties();
		try {
			InputStream input= getClass().getClassLoader().getResourceAsStream("config.properties");
			p.load(input);
			
			URLRates=p.getProperty("ratesAPI");
			URLDivisas=p.getProperty("divisasAPI");
			
			this.api_codigoMonedas=new API(URLRates);
			this.api_nombreMonedas=new API(URLDivisas);
			
			//ejecutar asincronamente
			ExecutorService executor = Executors.newFixedThreadPool(2);

	        Future<Boolean> future = executor.submit(() -> {
	        	Boolean api=this.api_codigoMonedas.consumoApi();
	            return api;
	        });
	        Future<Boolean> future2=executor.submit(()->{
	        	Boolean api=this.api_nombreMonedas.consumoApi();
	            return api;
	        });
	        
	        JOPanePers.Personalizar();
	        JOptionPane.showMessageDialog(null, "Esperar unos segundos respuesta de la API");
	        
	        try {
	        	if(!future.get() || !future2.get()) {
	        		this.exitoAPIS=false;
	        		JOptionPane.showMessageDialog(null, "No se pudo acceder a la aplicacion");
	        	}else {
	        		this.exitoAPIS=future.get();
	           		controlDatos.setAPICodigos(api_codigoMonedas);
					controlDatos.setAPINombres(api_nombreMonedas);
					controlDatos.iniciar();
	        	}
	        } catch (Exception e) {
	        	this.exitoAPIS=false;
	        	JOptionPane.showMessageDialog(null,"Error "+e,"Exception",JOptionPane.ERROR_MESSAGE);
	        }
	        executor.shutdown();
	        
		} catch (FileNotFoundException e) {
			this.exitoAPIS=false;
			JOptionPane.showMessageDialog(null,"Error "+e,"Exception",JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			this.exitoAPIS=false;
			JOptionPane.showMessageDialog(null,"Error "+e,"Exception",JOptionPane.ERROR_MESSAGE);
		}catch(Exception e) {
			this.exitoAPIS=false;
			JOptionPane.showMessageDialog(null,"Error "+e,"Exception",JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public TCDatos getControlDatos() {
		return this.controlDatos;
	}
	
	public boolean validacionApis() {
		return this.exitoAPIS;
	}
}
