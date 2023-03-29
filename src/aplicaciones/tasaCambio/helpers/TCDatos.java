package aplicaciones.tasaCambio.helpers;

import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONObject;

public class TCDatos {

	
	private String [] encabezado;
	private ArrayList<Integer> tamanoColumnas;

	private API api_codigoMonedas;
	private API api_nombreMonedas;
	private API_Manejo api_manejo;
	private ArrayList<Moneda> monedas;
	private ArrayList<String> options;
	
	public void setAPICodigos(API api_codigoMonedas) {
		this.api_codigoMonedas=api_codigoMonedas;
	}
	
	public void setAPINombres(API api_nombreMonedas) {
		this.api_nombreMonedas=api_nombreMonedas;
	}
	
	private void initEncabezado() {
		encabezado[0]="#";
		encabezado[1]="Moneda";
		encabezado[2]="Código";
		encabezado[3]="Tasa";
		encabezado[4]="Resultado";
	}
	
	public String[] getEncabezado() {
		return this.encabezado;
	}
	
	public Object[] getFilasTabla() {
		return new Object[]{"","","","",""};
	}
	
	public ArrayList<Moneda> getMonedas(){
		return this.monedas;
	}
	
	public ArrayList<Integer> getTamanoEncabezado(){
		return this.tamanoColumnas;
	}
	
	public ArrayList<String> getOptions(){
		return this.options;
	}
	
	private void initTamanoEncabezado() {
		tamanoColumnas.add(30);
		tamanoColumnas.add(220);
		tamanoColumnas.add(70);
		tamanoColumnas.add(110);
		tamanoColumnas.add(110);
	}
	
	private void initMonedas() {
		api_manejo=new API_Manejo((JSONObject) api_codigoMonedas.getJSONObject().get("rates"),api_nombreMonedas.getJSONObject());
		monedas=api_manejo.convertir_R_M();
		Collections.sort(monedas);
	}
	
	private void llenarOptions() {
		for(int i=0;i<monedas.size();i++) options.add(monedas.get(i).getCodigo()+" - "+monedas.get(i).getNombre());
	}
	
	public Moneda buscarMonedaInfo(String codigoNombre) {
		for(int i=0;i<monedas.size();i++) {
			if(codigoNombre.equals(monedas.get(i).getCodigo()+" - "+monedas.get(i).getNombre())) {
				return monedas.get(i);
			}
		}
		return null;
	}
	
	public void iniciar(){
		encabezado=new String[5];
		initEncabezado();
		
		tamanoColumnas=new ArrayList<>();
		initTamanoEncabezado();
		
		monedas=new ArrayList<>();		
		initMonedas();
		
		options=new ArrayList<>();
		llenarOptions();
	}

}
