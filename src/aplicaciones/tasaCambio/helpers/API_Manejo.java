package aplicaciones.tasaCambio.helpers;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.json.JSONObject;

public class API_Manejo {
	private JSONObject respuestaCodigos;
	private JSONObject respuestaNombres;
	
	public API_Manejo(JSONObject respuestaCodigos,JSONObject respuestaNombres) {
		this.respuestaCodigos=respuestaCodigos;
		this.respuestaNombres=respuestaNombres;
	}
	
	//convertimos la respuesta de la api a monedas
	public ArrayList<Moneda> convertir_R_M() {
		ArrayList<Moneda> convertido=new ArrayList<>();
		for (String key : respuestaCodigos.keySet()) {
			Moneda moneda=new Moneda();
			try {
				moneda.setNombre(respuestaNombres.getString(key));
				moneda.setCodigo(key);
				moneda.setValor(new BigDecimal(Double.toString(respuestaCodigos.getDouble(key))));
				convertido.add(moneda);
			}
			catch(Exception e) {
				//siempre existira un error debido a que la API 
				//openexchangerates contiene mas codigos de monedas
				//comparada con la API exchangerate
			}
		}
		return convertido;
	}
}
