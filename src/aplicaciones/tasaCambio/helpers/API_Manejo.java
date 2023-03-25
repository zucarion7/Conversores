package aplicaciones.tasaCambio.helpers;

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
				moneda.setValor(respuestaCodigos.getDouble(key));
				convertido.add(moneda);
			
//			System.out.println(" codigo: "+moneda.getCodigo()+" valor: "+moneda.getValor()+" nombre:"+respuestaNombres.getString(key));
			}
			catch(Exception e) {
				
			}
		}
		return convertido;
	}
}
